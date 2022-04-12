package main.problems.interval;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }  else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    public static void main(String[] args) {
        int[][] interval1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] interval2 = {{1,4},{4,5}};

        System.out.println(Arrays.deepToString(mergeIntervals(interval1)));
        System.out.println(Arrays.deepToString(mergeIntervals(interval2)));

    }
}
