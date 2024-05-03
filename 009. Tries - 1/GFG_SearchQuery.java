import java.lang.reflect.Array;
import java.util.*;
public class GFG_SearchQuery {
    TrieNode root;
    String prefix;
    public GFG_SearchQuery(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    public ArrayList<String> input(char c) {
        if (c == '#') {
            addSentence(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix += c;
        List<Node> list = search(prefix);

        list.sort((a, b) -> {
            if (a.times == b.times) {
                return a.sentence.compareTo(b.sentence);
            } else {
                return b.times - a.times;
            }
        });

        String[] result = new String[Math.min(3, list.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).sentence;
        }

        return new ArrayList<>(Arrays.asList(result));
    }

    private void addSentence(String sentence, int times) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.times += times;
    }

    private List<Node> search(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return new ArrayList<>();
            }
            node = node.children.get(c);
        }
        return node.sentences;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        List<Node> sentences;
        int times;

        TrieNode() {
            children = new HashMap<>();
            sentences = new ArrayList<>();
            times = 0;
        }
    }

    static class Node {
        String sentence;
        int times;

        Node(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
        }
    }
}
