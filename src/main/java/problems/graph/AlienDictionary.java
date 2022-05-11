package main.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    
    public static String returnAlienOrder(String[] words) {
        
        // Init data structures
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Process the words and build edges
        for (int i = 0;i < words.length - 1; i ++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            // Check the edge case where word 2 is a prefix of word 1
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Find the first non match and insert corresponding relation
            for (int j = 0; j<Math.min(word1.length(), word2.length()); j++) {
                char word1Char = word1.charAt(j);
                char word2Char = word2.charAt(j);
                if (word1Char != word2Char) {
                    adjList.get(word1Char).add(word2Char);
                    counts.put(word2Char, counts.get(word2Char) + 1);
                    break;
                }
            }
        }

        // Build the string
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        String[] words2 = {"z","x"};
        String[] words3 = {"z","x","z"};

        System.out.println(returnAlienOrder(words1));
        System.out.println(returnAlienOrder(words2));
        System.out.println(returnAlienOrder(words3));
    }
}
