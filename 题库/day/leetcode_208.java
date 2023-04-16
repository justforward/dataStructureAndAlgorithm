package 题库.day;

public class leetcode_208 {


    class Trie {
        // 树节点 上保存的数据
        class TrieNode {
            boolean isWord;
            TrieNode[] child;

            public TrieNode() {
                isWord = false;
                child = new TrieNode[26];
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode head = this.root;
            for (int i = 0; i < word.length(); i++) {
                int cur = word.charAt(i) - 'a';
                if (head.child[cur] == null) {
                    head.child[cur] = new TrieNode();
                }
                head = head.child[cur];
            }
            head.isWord = true;
        }

        public boolean search(String word) {
            TrieNode head = this.root;
            for (int i = 0; i < word.length(); i++) {
                int cur = word.charAt(i) - 'a';
                if (head.child[cur] == null) return false;
                head = head.child[cur];

            }
            return head.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (p.child[i] == null) return false;
                p = p.child[i];
            }
            return true;
        }


    }


}
