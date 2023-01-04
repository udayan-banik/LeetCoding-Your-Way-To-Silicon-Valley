class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        for (int i = 0; i < tasks.length;) {
            int j = i + 1;
            while (j < tasks.length && tasks[j] == tasks[i]) j++;
            if (j == i + 1) return -1;
            res += compute(j - i);
            i = j;
        }
        return res; 
    }

    private int compute(int i) {
        if (i % 3 == 0) return i / 3;
        if (i % 3 == 2) return (i - 2) / 3 + 1;
        return (i - 4) / 3 + 2;
    }
}