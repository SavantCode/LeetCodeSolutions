class Solution {
    public int reverseDegree(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int value = 26 - (c - 'a');
            int product = value * (i+1); // because 1 indexed string
            System.out.println(value); // 26

            result += product;

        }

        return result;
    }
}