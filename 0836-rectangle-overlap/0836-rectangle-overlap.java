class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int leftEdge = Math.max(rec1[0], rec2[0]);
        int rightEdge = Math.min(rec1[2], rec2[2]);

        int bottomEdge = Math.max(rec1[1], rec2[1]);
        int topEdge = Math.min(rec1[3], rec2[3]);

        boolean hasWidthOverlap = leftEdge < rightEdge;
        boolean hasHeightOverlap = bottomEdge < topEdge;

        return hasWidthOverlap && hasHeightOverlap;
    }
}
