class Solution {
    class Point {
        int pos, height;
        public Point(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> rst = new ArrayList<>();
        if (isInvalid(buildings)) return rst;
        
        // init: sort points by pos
        PriorityQueue<Point> queue = buildQueue(buildings);

        // Mark height and calcualte the outline point.
        PriorityQueue<Integer> maxHeightQueue = new PriorityQueue<>(Collections.reverseOrder());
        maxHeightQueue.offer(0);
        int prevPeak = maxHeightQueue.peek();

        // process
        while (!queue.isEmpty()) {
            Point point = queue.peek();
            
            // 1) Add and trim all points on one X position
            while (!queue.isEmpty() && queue.peek().pos == point.pos) {
                point = queue.poll();
                if (point.height < 0) maxHeightQueue.offer(-point.height);
                else maxHeightQueue.remove(point.height); // remove 1 instance of this height, which marks end point of a building            
            }
            // 2) Add peak
            int currPeak = maxHeightQueue.peek();
            if (currPeak != prevPeak) {
                List list = new ArrayList<>();
                list.add(point.pos);
                list.add(currPeak);
                rst.add(list);
                prevPeak = currPeak;
            }
        }
        return rst;
    }
    
    private PriorityQueue<Point> buildQueue(int[][] buildings) {
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> a.pos - b.pos);
        for (int i = 0; i < buildings.length; i++) {
            queue.offer(new Point(buildings[i][0], -buildings[i][2])); // mark starting height negative
            queue.offer(new Point(buildings[i][1], buildings[i][2]));
        }
        return queue;
    }
    private boolean isInvalid(int[][] buildings) {
        return buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0;
    }
}