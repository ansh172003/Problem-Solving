class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord = false;
    public String word;
    public int count = 0;
}