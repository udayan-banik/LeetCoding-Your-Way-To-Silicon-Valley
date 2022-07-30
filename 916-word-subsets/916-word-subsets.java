class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
		List<String> result=new ArrayList<>();
		int word2Count[] = new int[26];
		
		//Form word2 with array on count of each possible alphabets from words
		for(String wordTwo: words2) {
			int temp[] = new int[26];
			for(char c:wordTwo.toCharArray()) {
				temp[c-'a']++;
				word2Count[c-'a'] = Math.max(word2Count[c-'a'], temp[c-'a']);
			}
		}

		//Form word1 with array on count of each possible alphabets from words
		for(String wordOne: words1) {
			int word1Count[] = new int[26];
			for(char c:wordOne.toCharArray()) {
				word1Count[c-'a']++;
			}
			
			boolean canAdd=true;
			for(int i=0;i<26;i++) {
				if(word1Count[i]<word2Count[i]) {
					canAdd=false;
					break;
				}
			}
			if(canAdd)
				result.add(wordOne);
		}

		return result;
    }
}