class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return getSkyline(0, buildings.length - 1, buildings);
    }
    
    public List<List<Integer>> getSkyline(int from, int to, int[][] buildings) {
        if (from == to) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(List.of(buildings[from][0], buildings[from][2]));
            res.add(List.of(buildings[from][1], 0));
            return res;
        }
        
        int mid = from + (to - from) / 2;
        List<List<Integer>> leftRet = getSkyline(from, mid, buildings);
        List<List<Integer>> rightRet = getSkyline(mid + 1, to, buildings);
        return merge(leftRet, rightRet);
    }
    
    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        int ly = 0, ry = 0;
        
        while (i < left.size() && j < right.size()) {
            List<Integer> l = left.get(i);
            List<Integer> r = right.get(j);
            int curX = 0;
            
            if (l.get(0) < r.get(0)) {
                curX = l.get(0);
                ly = l.get(1);
                i++;
            } else if (l.get(0) > r.get(0)) {
                curX = r.get(0);
                ry = r.get(1);
                j++;
            } else {
                curX = l.get(0);
                ly = l.get(1);
                ry = r.get(1);
                i++;
                j++;
            }
            
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != Math.max(ly, ry)) {
                res.add(List.of(curX, Math.max(ly, ry)));
            }
        }
        
        while (i < left.size()) {
            res.add(left.get(i++));
        }
        
        while (j < right.size()) {
            res.add(right.get(j++));
        }
        return res;
    }
}