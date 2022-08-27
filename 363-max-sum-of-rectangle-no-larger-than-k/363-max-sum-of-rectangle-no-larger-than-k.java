class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }

            int m = matrix.length,
                n = matrix[0].length,
                res = Integer.MIN_VALUE;
            int[][] sum = new int[m][n]; // sum of the rectangle (0, 0) to (i, j)
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int area = matrix[i][j];
                    if (i > 0) area += sum[i - 1][j];
                    if (j > 0) area += sum[i][j - 1];
                    if (i > 0 && j > 0) area -= sum[i - 1][j - 1];
                    sum[i][j] = area;

                    for (int r = 0; r <= i; ++r) {
                        for (int c = 0; c <= j; ++c) {
                            int d = sum[i][j];
                            if (r > 0) d -= sum[r - 1][j];
                            if (c > 0) d -= sum[i][c - 1];
                            if (r > 0 && c > 0) d += sum[r - 1][c - 1];
                            if (d <= k) res = Math.max(res, d);
                        }
                    }
                }
            }
            return res;
        }
}