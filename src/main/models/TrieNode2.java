package main.models;

public class TrieNode2 {

    // R links to node children
    private TrieNode2[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode2() {
        links = new TrieNode2[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode2 get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode2 node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
