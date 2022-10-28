public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, Integer> helper = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i ++) {
            char[] tmpChar = strs[i].toCharArray();
            Arrays.sort(tmpChar);
            String tmp = new String(tmpChar);
            if (helper.containsKey(tmp)) {
                result.get(helper.get(tmp)).add(strs[i]);
                continue;
            }
            List<String> curr = new LinkedList<String>();
            curr.add(strs[i]);
            result.add(curr);
            helper.put(tmp, result.size() - 1);
        }
        return result;
    }
}