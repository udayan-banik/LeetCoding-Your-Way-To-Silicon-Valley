class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.parallelSort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowsNeeded = 0;
        int limit = -1;
        for (int[] point : points) {
            if (arrowsNeeded == 0 || point[0] > limit) {
                limit = point[1];
                ++arrowsNeeded;
            }
        }
        return arrowsNeeded;
    }
}