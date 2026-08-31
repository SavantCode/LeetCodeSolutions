class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ArrayList<Integer> indexes = new ArrayList<>();

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        int idx = 0;

        while (next != null) {

            // Local minima
            if (prev != null &&
                curr.val < prev.val &&
                curr.val < next.val) {

                indexes.add(idx);
            }

            // Local maxima
            if (prev != null &&
                curr.val > prev.val &&
                curr.val > next.val) {

                indexes.add(idx);
            }

            prev = curr;
            curr = next;
            next = next.next;
            idx++;
        }

        // Fewer than 2 critical points
        if (indexes.size() < 2) {
            return new int[]{-1, -1};

            // ❌ YOUR ORIGINAL:
            // return new int[-1.-1];
            //
            // Problems:
            // 1. Array values need { }, not [ ]
            // 2. You had "-1.-1", which is invalid syntax
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < indexes.size(); i++) {

            int distance = indexes.get(i) - indexes.get(i - 1);

            min = Math.min(min, distance);

            // ❌ YOUR ORIGINAL approach for max:
            // max = Math.max(max, distance);
            //
            // This finds the maximum distance BETWEEN CONSECUTIVE
            // critical points.
            //
            // But the problem asks for the distance between the
            // FIRST and LAST critical points.
        }

        // Maximum distance = last critical point - first critical point
        max = indexes.get(indexes.size() - 1) - indexes.get(0);

        // ❌ YOUR ORIGINAL:
        // return new int [min, max];
        //
        // Array initialization in Java uses { }, not [ ].
        return new int[]{min, max};
    }
}

// minDistance = the smallest gap between any two consecutive critical points.

// maxDistance = distance from the first critical point to the last critical point.

