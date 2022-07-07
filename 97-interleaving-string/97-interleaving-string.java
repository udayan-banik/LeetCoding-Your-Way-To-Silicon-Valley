class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int l1 = c1.length, l2 = c2.length;
        if (l1 + l2 != c3.length) {
            return false;
        }
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[l1 + 1][l2 + 1]);
    }
    
    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        if (k == c3.length) return true;
        boolean valid = 
            i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
            j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        
        if (!valid) {
            invalid[i][j] = true;
        }
        return valid;
    }
}