import java.util.*;
public class LC_ReplaceWords {
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        for (String w : dictionary){
            insert(w);
        }
        String[] allWords = sentence.split(" ");
        for (String w : allWords)
            sb.append(' ').append(search(w));
        return sb.substring(1);
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.word = word;
    }

    String search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.word != null)
                return node.word;
            int i = c - 'a';
            if (node.children[i] == null)
                return word;
            node = node.children[i];
        }
        return word;
    }
}
