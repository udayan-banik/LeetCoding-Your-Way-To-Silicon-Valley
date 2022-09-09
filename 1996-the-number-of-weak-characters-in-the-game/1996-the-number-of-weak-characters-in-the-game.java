import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        if (properties == null || properties.length < 2) {
            return 0;
        }

        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int max = 0;

        int ans = 0;

        for (int i = properties.length - 1; i >= 0; --i) {
            if (properties[i][1] < max) {
                ans++;
            }
            max = Math.max(properties[i][1], max);
        }

        return ans;
    }
}