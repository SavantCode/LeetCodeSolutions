import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        // Put nums1 values into s1
        for (int value : nums1) {
            s1.push(value);
        }

        // Put nums2 values into st2
        for (int value : nums2) {
            st2.push(value);
        }

        Stack<Integer> smaller;
        Stack<Integer> larger;

        if (s1.size() < st2.size()) {
            smaller = s1;
            larger = st2;
        } else {
            smaller = st2;
            larger = s1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Match values from the smaller stack with the larger stack
        while (!smaller.isEmpty()) {
            int value = smaller.pop();

            if (larger.contains(value) && !list.contains(value)) {
                list.add(value);
            }
        }

        // Convert ArrayList<Integer> to int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
