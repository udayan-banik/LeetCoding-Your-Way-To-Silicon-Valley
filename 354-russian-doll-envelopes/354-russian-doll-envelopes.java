class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) return envelopes.length;
        
        Arrays.sort(envelopes, new EnvelopeSizeComparator());
        int[] dp = new int[envelopes.length];
        int size = 0;
        
        for(int[] envelope: envelopes) {
            // binary search
            int left = 0, right = size, middle = 0;     // right = size
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < envelope[1]) left = middle + 1;
                else right = middle;
            }
            
            // left is the right position to 'replace' in dp array
            dp[left] = envelope[1];
            if(left == size) size++;
        }
        return size;
    }
    
    class EnvelopeSizeComparator implements Comparator<int[]> {
        public int compare(int[] env1, int[] env2) {
            return env1[0] == env2[0] ? env2[1] - env1[1] : env1[0] - env2[0];
        }
    }
}