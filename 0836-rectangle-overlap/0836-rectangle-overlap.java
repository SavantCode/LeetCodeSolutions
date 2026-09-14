class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check if there is positive overlap on X-axis
        boolean overlapX = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);

        // Check if there is positive overlap on Y-axis
        boolean overlapY = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);

        return overlapX && overlapY;
    }
}
