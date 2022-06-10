class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> h=new HashSet<>();
        Queue<Character> q=new LinkedList<>();
        int temp=0;
        int max=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(h.contains(ch)){
                while(q.peek() != ch){
                    char v=q.remove();
                    h.remove(v);
                }
                q.remove();
                q.add(ch);
                
            }
            else{
                h.add(ch);
                q.add(ch);
            }
            temp=q.size();
            max=Math.max(max,temp);
        }
        return max;
    }
}