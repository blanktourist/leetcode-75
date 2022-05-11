package main.problems.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    
    public static boolean returnSolutionToWordBreak(String s, List<String> dictionary) {
        if (s == null || s.isEmpty()) {
            return true;
        }        

        for (String word : dictionary) {
            if (s.startsWith(word)) {
                String trimmed = s.substring(word.length());
                boolean ans = returnSolutionToWordBreak(trimmed, dictionary);
                if (ans) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String test1 = "leetcode";
        List<String> dictionary1 = Arrays.asList("leet","code");
        String test2 = "applepenapple";
        List<String> dictionary2 = Arrays.asList("apple","pen");
        String test3 = "catsandog";
        List<String> dictionary3 = Arrays.asList("cats","dogs", "sand", "and", "cat");

        System.out.println(returnSolutionToWordBreak(test1, dictionary1));
        System.out.println(returnSolutionToWordBreak(test2, dictionary2));
        System.out.println(returnSolutionToWordBreak(test3, dictionary3));
    }    
}
