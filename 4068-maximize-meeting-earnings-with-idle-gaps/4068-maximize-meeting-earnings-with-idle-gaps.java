import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public long maxEarnings(int[][] meetings) {
        // Sort meetings by end time ascending
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        // map key: end time, value: max profit achievable ending at or before key (shifted by key)
        // dp.get(t) stores max( sum(revenue - duration) + last_meeting_start )
        TreeMap<Long, Long> dp = new TreeMap<>();
        dp.put(0L, Long.MIN_VALUE / 2); 

        long maxOverallProfit = 0;

        for (int[] m : meetings) {
            long start = m[0];
            long end = m[1];
            long revenue = m[2];
            long weight = revenue - (end - start);

            // 1. Single meeting case (no previous meeting)
            long bestIfFirst = revenue;

            // 2. Chained meeting case: find best previous meeting ending <= start
            Long prevEnd = dp.floorKey(start);
            long bestIfChained = Long.MIN_VALUE;
            if (prevEnd != null) {
                // dp.get(prevEnd) holds (accumulated weights + first_start)
                // Total profit = dp.get(prevEnd) + weight + (end - first_start)
                bestIfChained = dp.get(prevEnd) + weight + end;
            }

            long currentProfit = Math.max(bestIfFirst, bestIfChained);
            maxOverallProfit = Math.max(maxOverallProfit, currentProfit);

            // Store value shifted by end time for easy transition to future meetings:
            // stored_value = currentProfit - end
            long valueToStore = currentProfit - end;

            Long existing = dp.floorKey(end);
            if (existing == null || dp.get(existing) < valueToStore) {
                dp.put(end, valueToStore);
            }
        }

        return maxOverallProfit;
    }
}