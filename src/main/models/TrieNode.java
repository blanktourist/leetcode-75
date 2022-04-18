package main.models;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public boolean word;

    public String toString;
    
    public Map<Character, TrieNode> children;

    public TrieNode() {
        word = false;
        children = new HashMap<>();
    }
}
