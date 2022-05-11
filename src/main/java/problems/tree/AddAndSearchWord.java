package main.problems.tree;

import main.models.TrieNode;

public class AddAndSearchWord {
    
    public static class WordDictionary {

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = true;
            System.out.println("Added word: " + word);
        }
        
        public boolean search(String word) {
            boolean result = searchInTrie(word, root);
            if (result) {
                System.out.println("Found: " + word);
            } else {
                System.out.println("Did not find: " + word);
            }
            return result;
        }

        private boolean searchInTrie(String word, TrieNode node) {
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);

                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else { // Otherwise we check the '.' case    
                    if (c == '.') {
                        for (char x : node.children.keySet()) {
                            TrieNode child = node.children.get(x);
                            if (searchInTrie(word.substring(i+1), child)) {
                                return true;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }

            return node.word;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }
}
