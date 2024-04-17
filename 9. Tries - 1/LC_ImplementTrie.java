public class LC_ImplementTrie {
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isWord = true;
    }
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    TrieNode find(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }

}
