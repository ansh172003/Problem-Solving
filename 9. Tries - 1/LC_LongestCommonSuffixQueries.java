class trie {
    public trie[] next = new trie[26];
    public int idx = -1;
    public int val = -1;
}

class LC_LongestCommonSuffixQueries {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        trie trie = new trie();
        for (int i = 0; i < wordsContainer.length; ++i) {
            String w = new StringBuilder(wordsContainer[i]).reverse().toString();
            trie node = trie;
            if (node.val == -1 || w.length() < node.val) {
                node.idx = i;
                node.val = w.length();
            }
            for (var ch : w.toCharArray()) {
                if (node.next[ch-'a'] == null)
                    node.next[ch-'a'] = new trie();
                node = node.next[ch-'a'];
                if (node.val == -1 || w.length() < node.val) {
                    node.idx = i;
                    node.val = w.length();
                }
            }
        }
        int n = wordsQuery.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            String w = new StringBuilder(wordsQuery[i]).reverse().toString();
            trie node = trie;
            for (var ch : w.toCharArray()) {
                if (node.next[ch-'a'] == null) break;
                node = node.next[ch-'a'];
            }
            res[i] = node.idx;
        }
        return res;
    }
};