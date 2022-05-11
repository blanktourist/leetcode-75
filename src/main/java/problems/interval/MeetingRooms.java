package main.problems.interval;

import java.util.Arrays;

public class MeetingRooms {
    
    public static boolean canAttendAllMeetings(int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        for (int i = 0; i < meetings.length - 1; i++) {
            if (meetings[i][1] > meetings[i+1][0]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};

        System.out.println(canAttendAllMeetings(intervals1));
        System.out.println(canAttendAllMeetings(intervals2));
    }
}
