class Solution {
    public int minimumDeviation(int[] nums) {
    if (nums == null || nums.length == 0) {
        return Integer.MAX_VALUE;
    }

    PriorityQueue<Integer> evens = new PriorityQueue<>(nums.length, Collections.reverseOrder());
    int min = Integer.MAX_VALUE;
    // Throw it all in maxheap, and record what the current minimum number is by the way
    for (int num : nums) {
        if (num % 2 == 0) {
            evens.offer(num);
            min = Math.min(num, min);
        } else {
            evens.offer(num * 2);
            min = Math.min(num * 2, min);
        }            
    }
    // Loop to find minDiff, if it is an odd number, we know that we have finished searching
    int res = Integer.MAX_VALUE;
    while (evens.peek() % 2 == 0) {
        int max = evens.poll();
        res = Math.min(res, max - min);
        int newNum = max / 2; //Divide by 2, throw it back and see if you can find a smaller one
        evens.offer(newNum);
        min = Math.min(min, newNum); // Remember to update min
    }

    res = Math.min(evens.peek() - min, res);
    return res;
}
}