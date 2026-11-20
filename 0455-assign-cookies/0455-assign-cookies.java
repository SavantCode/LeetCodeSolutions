import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int glen = g.length;
        int slen = s.length;

        int greed = 0;
        int cookie = 0;
        int count = 0;

        while (cookie < slen && greed < glen) {
            if (s[cookie] >= g[greed]) {
                count++;
                greed++;
            }
            cookie++;
        }

        return count;
    }
}