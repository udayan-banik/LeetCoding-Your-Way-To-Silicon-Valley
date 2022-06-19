class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int[] ra = {0, products.length};
        for(int i = 0; i < searchWord.length(); i++) {
            suggestion(products, searchWord, ra, i);
        }
        return result;
    }
    private List<List<String>> result = new ArrayList<>();
    private void suggestion(String[] products, String searchWord, int[] ra, int j) {
        List<String> cur = new ArrayList<>();
        int newStart = -1, k = ra[0];
        for(; k < ra[1]; k++) {
            if (j < products[k].length() && products[k].charAt(j) == searchWord.charAt(j)) {
                if (newStart == -1) newStart = k;
                if (cur.size() < 3) {
                    cur.add(products[k]);
                }
            } else {
                if (newStart != -1) break;
            }
        }
        result.add(cur);
        if(newStart == -1) newStart = k;
        ra[0] = newStart;
        ra[1] = k;
    }
}