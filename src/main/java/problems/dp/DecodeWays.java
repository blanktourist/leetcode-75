package main.problems.dp;

import java.util.Arrays;
import java.util.List;

public class DecodeWays {
    
    public static int count;

    public static List<String> dictionary = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","16","17","18","19","20","21","22","23","24","25","26");

    public static int returnSolutionToDecodeWays(String s) {
        count = 0;

        dp(s);

        return count;
    }

    public static void dp(String remaining) {
        if (remaining == null || remaining.length() == 0) {
            count++;
        }

        for (String word : dictionary) {
            if (remaining.startsWith(word)) {
                dp(remaining.substring(word.length()));
            }
        }
    }
    
    public static void main(String[] args) {
        String test1 = "12";
        String test2 = "226";
        String test3 = "06";

        System.out.println(returnSolutionToDecodeWays(test1));
        System.out.println(returnSolutionToDecodeWays(test2));
        System.out.println(returnSolutionToDecodeWays(test3));
    }
}