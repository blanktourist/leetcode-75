package main.problems.graph;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    
    public static int returnLongestConsecutiveSequence(int[] arr) {
        Set<Integer> arrSet = new HashSet<>();
        for (int i : arr) {
            arrSet.add(i);
        }

        int longestStreak = 0;
        for (int i : arr) {
            if (!arrSet.contains((i-1))) {
                int currentNum = i;
                int currentStreak = 1;
                while (arrSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;

    }
    public static void main(String[] args) {
        int[] test1 = {100,4,200,1,3,2};
        int[] test2 = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(returnLongestConsecutiveSequence(test1));
        System.out.println(returnLongestConsecutiveSequence(test2));
    }
}
