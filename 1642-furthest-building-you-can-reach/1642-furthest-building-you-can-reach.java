class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int step = 0;
        boolean end = false;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        int[] diff = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) {
                diff[i] = 0;
            } else {
                if (heights[i]  <= heights[i-1] ) {
                    diff[i] = 0;
                } else {
                    diff[i] = heights[i] - heights[i-1];
                }
            }
        }
        
        int total = 0;
        int total_ladders = 0;
        
        for (int i = 0; i < diff.length; i++) {
            int cur = diff[i];
            total += cur;
            if (que.size() < ladders) {
                que.add(cur);
                total_ladders += cur;
            } else {
                if (que.size() > 0 && cur > que.peek()) {
                    total_ladders += (cur - que.peek());
                    que.poll();
                    que.add(cur);
                }
            }
            
            if (bricks < total - total_ladders) {
                step = i - 1;
                break;
            } else {
                step = i;
            }
        }

        return step;
        
    }
}