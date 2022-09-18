/*

maxLeftHeight =  [0,0,1,1,2,2,2,2,3,3,3,3]
maxRightHeight = [3,3,3,3,3,3,3,2,2,2,1,0]
min = [0,0,1,1,2,2,2,2,2,2,1,0]

waterAmt = 0;


*/
class Solution {
    public int trap(int[] height) {
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];
        int[] minHeight = new int[height.length];
        int waterCount = 0;
        
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeftHeight[i] = max;
            if (height[i] > max)
                max = height[i];
        }
        
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRightHeight[i] = max;
            if (height[i] > max)
                max = height[i];
            
            minHeight[i] = Math.min(maxLeftHeight[i], maxRightHeight[i]);
        }
        
        for (int i = 0; i < height.length; i++) {
            int diff = minHeight[i] - height[i];
            if (diff > 0)
                waterCount += diff;
        }
        
        return waterCount;
    }
}