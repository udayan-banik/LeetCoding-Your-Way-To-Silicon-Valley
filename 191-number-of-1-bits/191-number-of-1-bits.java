public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return n==0?0:1+hammingWeight(n & (n - 1));
    }
}