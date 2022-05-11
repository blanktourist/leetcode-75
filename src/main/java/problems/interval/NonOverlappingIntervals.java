package main.problems.interval;

import java.util.Arrays;

public class NonOverlappingIntervals {
    
    public static int returnMinIntervalsToRemove(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i<intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        int[][] intervals3 = {{1,2},{2,3}};

        System.out.println(returnMinIntervalsToRemove(intervals1));
        System.out.println(returnMinIntervalsToRemove(intervals2));
        System.out.println(returnMinIntervalsToRemove(intervals3));
    }
}
