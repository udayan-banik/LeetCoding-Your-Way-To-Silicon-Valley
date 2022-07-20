class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<Node>[] heads = new ArrayList[26];
        for (char i = 'a'; i <= 'z'; i++) {
            heads[i - 'a'] = new ArrayList<>();
        }
        
        // match each word from index 0
        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        
        int ret = 0;
        for (char c : S.toCharArray()) {
            ArrayList<Node> waiting = new ArrayList<>(heads[c - 'a']);
            heads[c - 'a'].clear();
            for (Node n : waiting) {
                n.nextIndex++;
                if (n.nextIndex == n.word.length()) {
                    ret++;
                } else {
                    heads[n.word.charAt(n.nextIndex) - 'a'].add(n);
                }
            }
        }
        
        return ret;
    }
    
    class Node {
        String word;
        int nextIndex;
        Node(String word, int index) {
            this.word = word;
            this.nextIndex = index;
        }
    }
}