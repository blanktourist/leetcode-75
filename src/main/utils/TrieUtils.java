package main.utils;

import main.models.TrieNode2;

public class TrieUtils {
    public static class Trie {
        private TrieNode2 root;
    
        public Trie() {
            root = new TrieNode2();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode2 node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode2());
                }
                node = node.get(currentChar);
            }
            node.setEnd();

            System.out.println("Inserted: " + word);
        }

        // search a prefix or whole key in trie and
        // returns the node where search ends
        private TrieNode2 searchPrefix(String word) {
            TrieNode2 node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode2 node = searchPrefix(word);
            boolean result = node != null && node.isEnd();
            return result;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode2 node = searchPrefix(prefix);
            boolean reuslt = node != null;
            return reuslt;
        }
    }
}
