class Solution {
    public int memo(String word1,String word2,int [][] dp,int i,int j){
     if(i<0) return j+1;
     if(j<0) return i+1;
     if(dp[i][j]!=-1) return dp[i][j];
     if(word1.charAt(i) == word2.charAt(j)){
        return dp[i][j] = 0+ memo(word1,word2,dp,i-1,j-1);
     }else{
         return dp[i][j] = 1 + Math.min(memo(word1,word2,dp,i,j-1),Math.min(memo(word1,word2,dp,i-1,j),memo(word1,word2,dp,i-1,j-1)));
     }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length(); 
        int [][] dp = new int[n][m];
        for(int [] rows:dp){
            Arrays.fill(rows,-1);
        }
         return memo(word1,word2,dp,word1.length()-1,word2.length()-1);
    }
}