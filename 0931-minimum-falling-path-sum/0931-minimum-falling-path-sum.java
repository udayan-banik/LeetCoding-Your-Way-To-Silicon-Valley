class Solution {
    int ans = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        helper(matrix, matrix.length-2);
        return ans;
    }

    void helper(int[][] matrix, int r) {
        if(r<0) {
            for(int i=0; i<matrix.length; i++) {
                ans = Math.min(ans, matrix[0][i]);
            }
            return;
        }
        
        for(int i=0; i<matrix.length; i++) {
            int minNextVal = matrix[r+1][i];
            if(i>0) {
                minNextVal = Math.min(minNextVal, matrix[r+1][i-1]);
            }
            if(i<matrix.length-1) {
                minNextVal = Math.min(minNextVal, matrix[r+1][i+1]);
            }
            matrix[r][i] += minNextVal;
        }

        helper(matrix, r-1);
    }
}