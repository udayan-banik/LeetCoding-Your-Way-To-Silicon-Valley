class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int median = findMedian(nums, 0, n - 1, n / 2);
        int ans = 0;
        for(int num : nums){
            ans += Math.abs(num - median);
        }
        return ans;
    }
    
    public int findMedian(int[] nums, int start, int end, int k){
        if(start >= end){
            return nums[start];
        }
        int left = start, right = end;
        int mid = nums[start + right >> 1];
        while(left <= right){
            while(nums[left] < mid){
                left++;
            }
            while(nums[right] > mid){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(start + k <= right){
            return findMedian(nums, start, right, k);
        }
        if(start + k >= left){
            return findMedian(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
}