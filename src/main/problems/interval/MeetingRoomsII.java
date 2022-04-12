package main.problems.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    
    public static int returnMinRoomsNeeded(int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int maxRooms = 0;
        for (int[] meeting : meetings) {
            int[] lastMeeting = queue.peek();
            if (lastMeeting == null || lastMeeting[1] > meeting[0]) {
                queue.add(meeting);
                maxRooms = Math.max(maxRooms, queue.size());
            } else {
                queue.poll();
                queue.add(meeting);
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};

        System.out.println(returnMinRoomsNeeded(intervals1));
        System.out.println(returnMinRoomsNeeded(intervals2));
    }
}
