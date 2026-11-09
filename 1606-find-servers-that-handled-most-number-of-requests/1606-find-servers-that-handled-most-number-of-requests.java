import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requestCount = new int[k];

        // 1. Available servers ordered by index for log(K) lookup
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // 2. Busy servers ordered by freeTime (min-heap): [freeTime, serverIndex]
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        for (int i = 0; i < arrival.length; i++) {
            long arrivalTime = arrival[i];
            long duration = load[i];
            int startServer = i % k;

            // Step A: Free up servers that finished their jobs by arrivalTime
            while (!busy.isEmpty() && busy.peek()[0] <= arrivalTime) {
                int freedServer = (int) busy.poll()[1];
                available.add(freedServer);
            }

            // Step B: Find candidate server starting at startServer
            if (!available.isEmpty()) {
                // Find smallest server index >= startServer
                Integer assignedServer = available.ceiling(startServer);
                
                // Wrap around if no server index >= startServer is free
                if (assignedServer == null) {
                    assignedServer = available.first();
                }

                // Step C: Assign job & update state
                available.remove(assignedServer);
                busy.offer(new long[]{arrivalTime + duration, assignedServer});
                requestCount[assignedServer]++;
            }
            // If available is empty, request is automatically dropped
        }

        // Find max requests and collect busiest servers
        int maxRequests = 0;
        for (int count : requestCount) {
            maxRequests = Math.max(maxRequests, count);
        }

        List<Integer> busiest = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                busiest.add(i);
            }
        }

        return busiest;
    }
}