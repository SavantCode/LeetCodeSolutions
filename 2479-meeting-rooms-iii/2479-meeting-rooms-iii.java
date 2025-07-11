import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by their start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Available rooms (min-heap by room number)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // Busy rooms: [endTime, roomNumber] as long to prevent overflow
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> (a[0] != b[0]) ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );

        // Count meetings handled by each room
        int[] counts = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            // Free all rooms that are done before this meeting's start time
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                int freedRoom = (int) busyRooms.poll()[1];
                availableRooms.offer(freedRoom);
            }

            if (availableRooms.isEmpty()) {
                // Delay the meeting until the earliest room becomes available
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                long newEnd = newStart + duration;
                int room = (int) earliest[1];
                counts[room]++;
                busyRooms.offer(new long[]{newEnd, room});
            } else {
                // Assign to the available room with the smallest number
                int room = availableRooms.poll();
                counts[room]++;
                busyRooms.offer(new long[]{end, room});
            }
        }

        // Find the room with the most meetings (tie -> smallest room number)
        int maxCount = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                answer = i;
            }
        }

        return answer;
    }
}
