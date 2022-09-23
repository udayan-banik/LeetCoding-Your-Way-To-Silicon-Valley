class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_000 + 7;
        
        long sum = 0;
        int len = 0;
        
        for (int i=1; i<=n; i++) {
            if ((i & (i-1)) == 0) {
                len++;
            }
            sum = ((sum << len) | i) % MOD;
        }
        
        return (int)sum;
    }
}