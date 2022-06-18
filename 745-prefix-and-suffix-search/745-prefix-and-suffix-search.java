class WordFilter {
    TrieNode root;
    String[] words;

    public WordFilter(String[] words) {
        root = new TrieNode();
        TrieNode node = root;
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (root.child[ch - 'a'] == null) {
                    root.child[ch - 'a'] = new TrieNode();
                }

                root.child[ch - 'a'].indexList.add(i);
                root = root.child[ch - 'a'];
            }
            root = node;
        }

        this.words = words;
    }

    public int f(String prefix, String suffix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.child[ch - 'a'];
            if (node == null) {
                return -1;
            }
        }

        List<Integer> list = node.indexList;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (words[list.get(i)].endsWith(suffix)) {
                return list.get(i);
            }
        }
        return -1;
    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        List<Integer> indexList = new ArrayList<>();
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */