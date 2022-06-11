class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        int s=sum-x;
        int i=0,j=0,c=0,l=0;
        if(s==0)
            return n;
        if(s<0)
            return -1;
        while(j<n){
            c+=nums[j];
            while(c>=s){
                if(c==s)
                  l=Math.max(l,j-i+1);
                c-=nums[i];
                i++;
            }
            j++;
        }
        if(l==0)
            return -1;
        return n-l;
    }
}