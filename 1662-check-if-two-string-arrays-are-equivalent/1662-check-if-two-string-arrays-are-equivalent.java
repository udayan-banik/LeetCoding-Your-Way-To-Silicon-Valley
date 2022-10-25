class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        while(true){
            if(w1[a1].charAt(b1) != w2[a2].charAt(b2)) return false;
            if(b1 == w1[a1].length()-1){a1++; b1 = 0;}
            else b1++;
            if(b2 == w2[a2].length()-1){a2++; b2 = 0;}
            else b2++;
            if(a1 == w1.length && a2 == w2.length)
                return true;
            else if(a1 == w1.length || a2 == w2.length)
                return false;
        }
    }
}