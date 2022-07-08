class Solution {
    
    int[][][] memo;
    int INT_MAX = 100000001;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new int[m][target+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<target+1;j++){
                for(int k=0;k<n+1;k++){
                    memo[i][j][k] = -1;
                }
            }
        }
        int res = minCostUtil(houses,cost,m,n,target,0,0);
        return (res==INT_MAX)?-1:res;
    }
int minCostUtil(int[] h, int[][] c, int m, int n, int t,int i, int previous){
        
        // GOAL BEGIN
        if(i==m){
            if(t==0){
                return 0;
            }
            return INT_MAX;
        }
        if(t<0){
            return INT_MAX;
        }
        // GOAL END
        
        if(memo[i][t][previous]!=-1){
            return memo[i][t][previous];
        }
        int ans = INT_MAX;
        
        //CONSTRAINT BEGIN
        if(h[i]==0){
            //CHOICE BEGIN
            for(int j=1;j<=n;j++){
                ans = Math.min(ans,c[i][j-1]+minCostUtil(h,c,m,n,t-((j!=previous)?1:0),i+1,j));
            }
            //CHOICE END
        } else{
            ans = minCostUtil(h,c,m,n,t-((h[i]!=previous)?1:0),i+1,h[i]);
        }
        //CONSTRAINT END
        
        memo[i][t][previous] = ans;
        return ans;
    }
    
}