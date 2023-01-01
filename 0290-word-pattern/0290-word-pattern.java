public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.trim().split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> bijection = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i ++) {
            char c = pattern.charAt(i);
            if (bijection.containsKey(c) && !bijection.get(c).equals(strs[i])) {
                return false;
            }
            if (!bijection.containsKey(c) && bijection.containsValue(strs[i])) {
                return false;
            }
            bijection.put(c, strs[i]);
        }
        return true;
    }
}