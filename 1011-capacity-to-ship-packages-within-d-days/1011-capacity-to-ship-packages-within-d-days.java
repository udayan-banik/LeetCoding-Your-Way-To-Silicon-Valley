class Solution {
    public int shipWithinDays(int[] a, int days) {
        int l = 0, r = 500 * a.length / days;
        // for (int w : a) {
        //     r += w;
        //     if (w > l) l = w;
        // }

        while (l < r) {
            int m = l + (r-l)/2;
            if (isEnough(a, m, days)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean isEnough(int[] a, int m, int d) {
        int cnt = 1, sum = 0;
        for (int w : a) {
            if (w > m) return false;
            if ((sum += w) > m) {
                if (++cnt > d) return false;
                sum = w;
            }
        }

        return true;
    }
}