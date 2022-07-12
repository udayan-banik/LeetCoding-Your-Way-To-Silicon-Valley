class Solution {
    boolean[] st;
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int x:nums) sum += x;
        if(sum == 0 || sum % 4 != 0) return false;
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            arr[i] = nums[nums.length -1 -i];
        }
        st = new boolean[nums.length];
        return dfs(nums,0,0,0,sum/4);
    }
    
    boolean dfs(int[] nums,int u,int cur,int start,int length) {
        if(u == 4) return true;
        if(cur == length) return dfs(nums,u+1,0,0,length);
        
        for(int i =start;i < nums.length;i++) {
            if(!st[i] && cur + nums[i] <= length) {
                st[i] = true;
                if(dfs(nums,u,cur + nums[i],i+1,length)) return true;
                st[i] =false;
                
                
                if(cur == 0) return false;
                if(cur + nums[i] == length) return false;
                while(i + 1 < nums.length && nums[i+1] == nums[i]) i++;
            }
        }
        return false;
    }
}