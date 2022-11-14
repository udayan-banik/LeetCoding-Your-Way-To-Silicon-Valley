class Solution {
    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(20000);
        for(int[] stone: stones){
            ds.union(stone[0], stone[1]+10000);
        }
 
        HashSet<Integer> set = new HashSet<>();
        for(int[] stone: stones){
            set.add(ds.find(stone[0]));
        }
 
        return stones.length - set.size();
    }
}
 
class DisjointSet{
    int[] parent;
    public DisjointSet(int size){
        parent = new int[size];
        for(int i=0; i<size; i++){
            parent[i] = i;
        }
    }
 
    public void union(int i, int j){
        parent[find(i)] = find(j);
    }
 
    public int find(int i){
        while(parent[i] != i){
            i = parent[i];
        }
 
        return i;
    }
}