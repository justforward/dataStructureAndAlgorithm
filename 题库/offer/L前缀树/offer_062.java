package 题库.offer.L前缀树;

public class offer_062 {


    class Trie {

        // 根节点
        Node root;

        class Node {
            boolean isWord;
            Node[] child;

            public Node() {
                isWord = false;
                // 子节点上的单词为26个
                child = new Node[26];
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node head = root;
            // 插入数字
            for (int i = 0; i < word.length(); i++) {
                int cur = word.charAt(i) - 'a';
                if (head.child[cur] == null) {
                    head.child[cur] = new Node();
                }
                head = head.child[cur];
            }
            head.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node head = root;
            for (int i = 0; i < word.length(); i++) {
                int cur = word.charAt(i) - 'a';
                if (head.child[cur] == null) {
                    return false;
                }
                head = head.child[cur];
            }
            // 不是前缀 必须是word
            return head.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node head = root;
            for (int i = 0; i < prefix.length(); i++) {
                int cur = prefix.charAt(i) - 'a';
                if (head.child[cur] == null) {
                    return false;
                }
                head = head.child[cur];
            }
            // 不是前缀 必须是word
            return true;
        }
    }

}
