class Solution {
    public int numMatchingSubseq(String s, String[] words) {
     Word[] heads = new Word[26];
        for (int i = 0; i < 26; i++) heads[i] = new Word("", 0);
        for (String word : words) {
            Word head = heads[word.charAt(0) - 'a'];
            Word newWord = new Word(word, 0);
            newWord.next = head.next;
            head.next = newWord;
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Word curHead = heads[c - 'a'];
            Word cur = curHead.next;
            curHead.next = null;
            while (cur != null) {
                Word next = cur.next;
                if (cur.index == cur.word.length() - 1) {
                    ans++;
                } else {
                    cur.index++;
                    Word nextHead = heads[cur.word.charAt(cur.index) - 'a'];
                    cur.next = nextHead.next;
                    nextHead.next = cur;
                }
                cur = next;
            }
        }
        return ans;
    }
    
    class Word {
        String word;
        int index;
        Word next;
        Word(String word, int index) {
            this.word = word;
            this.index = index;
        }
}
}