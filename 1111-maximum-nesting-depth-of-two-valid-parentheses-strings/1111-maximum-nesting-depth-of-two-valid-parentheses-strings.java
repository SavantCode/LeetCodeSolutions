//Approach - Greedily divide depth in half
//T.C - O(n)
//S.C - O(1)
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                result[i] = depth % 2 == 0 ? 0 : 1;
            } else {
                result[i] = depth % 2 == 0 ? 0 : 1;
                depth--;
            }
        }

        return result;
    }
}