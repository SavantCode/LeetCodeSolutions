// Time Complexity: O(n³)
// Space Complexity: O(1)
// Formula Used: Shoelace Formula (also called the Surveyor’s Formula or Determinant Formula)

//Formula:
// Area = (1/2)​ {∣x1​(y2​−y3​)+x2​(y3​−y1​)+x3​(y1​−y2​)|}
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double area = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int xi = points[i][0];
                    int yi = points[i][1];

                    int xj = points[j][0];
                    int yj = points[j][1];

                    int xk = points[k][0];
                    int yk = points[k][1];

                    double currArea = 0.5 * Math.abs(
                        xi * (yj - yk) +
                        xj * (yk - yi) +
                        xk * (yi - yj)
                    );

                    area = Math.max(area, currArea);
                }
            }
        }

        return area;
    }
}
