package org.example._2023_03_22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Compress {
    public static void main(String[] args) {
        String text = """
                A team of researchers led by Cambridge University 
                analysed five locks of hair to sequence the composer's genome.
                They were, however, unable to establish a definitive cause of his hearing loss.

                Lead author, Tristan Begg, said genetic risk factors, coupled with 
                Beethoven's high alcohol consumption, may have contributed to his liver condition.

                The international team analysed strands from eight locks of hair kept 
                in public and private collections, in a bid to shed light on Beethoven's health problems.

                Five locks were deemed "authentic" by the researchers and came from a single European male.""";

        String milk = "MOLOKO";
    }

    //1. Считаем сколько раз каждый символ встречается в тексте
    private static TreeMap<Character, Integer> countChar(String text) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = map.get(c);
            map.put(c, count != null ? count + 1 : 1);
        }
        return map;
    }

    //2. Класс нашего кодового дерева
    private static class CodeTreeNode implements Comparable<CodeTreeNode> {
        Character content; // наш символ
        int weight; //кол-во повторений
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - weight;
        }

        //4. Кодировать текст
        public String getCodeForChar(Character ch, String parentPath) {
            if (content == ch) {
                return parentPath;
            } else {
                if (left != null) {
                    String path = left.getCodeForChar(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }

                if (right != null) {
                    String path = right.getCodeForChar(ch, parentPath + 1);
                    if (path != null) {
                        return path;
                    }
                }
            }
            return null;
        }
    }

    //3. Алгоритм обхода, который принимает список узлов,
    //а возвращать дерево
    private static CodeTreeNode getHuff(ArrayList<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);

            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }

    //5. Тут декодируем
    private static String getDecode(String encoded, CodeTreeNode tree) {
        StringBuilder decoded = new StringBuilder();

        CodeTreeNode node = tree;
        for (int i = 0; i < encoded.length(); i++) {
            node = encoded.charAt(i) == '0' ? node.left : node.right;
            if(node.content != null) {
                decoded.append(node.content);
                node = tree;
            }
        }
        return decoded.toString();
    }
}