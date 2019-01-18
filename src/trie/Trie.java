package trie;

import java.util.TreeMap;

/**
 * @author lixw
 * @date created in 23:15 2019/1/16
 */

/**
 * public class trie <C> 可以加一个泛型
 *
 * @param
 */
public class Trie {
    /**
     * Node域中还可以定义释意 和 词频 字段
     */
    private class Node {
        public boolean isWord;
        /**
         * 如果使用泛型
         * public TreeMap<C,Node> next;
         */
        public TreeMap<Character, Node> next;

        /**
         * 有参数构造
         *
         * @param isWord
         */
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        /**
         * 相当于一个无参构造
         */
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    /**
     * 对于外部类的构造函数：
     */
    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie中储存的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;

    }

    /**
     * 想Trie中添加一个新的单词
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            /**
             * 插入节点之前需要先判断下一个节点是否指向
             * 与将要插入的字符相同
             *
             * 即 已经包含了节点到 C 的映射
             * 树就不需要再新创建一个 节点来保存这个字符
             */
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            /**
             * 直接走到相应的节点
             */
            cur = cur.next.get(c);
        }
        /**
         * 保证如果之前存在这个单词
         * 不会重复累加
         */
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }


    /**
     * 查询单词word是否在Trie中
     * 非递归的算法
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            /**
             * 如果在字典树中找不到相应的节点字符的话
             * 说明字典树中没有存储相应的单词
             */
            if(cur.next.get(c) == null){
                return false;
            }
            /**
             *如果有继续
             */
            cur = cur.next.get(c);
        }
        /**
         * 出循环说明查完了字符串的
         * 最后的一个字符
         * 不能直接 return true  如：有panda 查 pan
         * 如果树中 pan 所对应的
         * isword 是false的 那么就说明没有这个单词
         */
        return cur.isWord;

    }
}
