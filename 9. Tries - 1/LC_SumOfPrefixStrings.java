class nodeTRIE {
    public nodeTRIE[] children = new nodeTRIE[26];
    public int count = 0;
}

class LC_SumOfPrefixStrings {
    nodeTRIE root = new nodeTRIE();
    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];
        for (String word : words)
            insert(word);
        for (int i = 0; i < words.length; ++i)
            ans[i] = findScore(words[i]);
        return ans;
    }


    void insert(String word) {
        nodeTRIE node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new nodeTRIE();
            node = node.children[i];
            ++node.count;
        }
    }

    private int findScore(String word) {
        nodeTRIE node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];
            score += node.count;
        }
        return score;
    }
}
