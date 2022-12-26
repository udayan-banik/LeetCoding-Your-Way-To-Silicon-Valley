class Solution {
    public boolean canJump(int[] nums) {

        int goal_post = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int jump_distance = i + nums[i];
            if (jump_distance >= goal_post) {
                goal_post = i;
            }
        }

        return (goal_post == 0) ? true : false;
    }
}