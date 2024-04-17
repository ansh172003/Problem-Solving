import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GFG_AutoComplete {
    public class NodeTrie {
        Map<Character, NodeTrie> children;
        char c;
        boolean isWord;
        public NodeTrie(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        public NodeTrie() {
            children = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            NodeTrie child = children.get(firstChar);
            if (child == null) {
                child = new NodeTrie(firstChar);
                children.put(firstChar, child);
            }

            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.isWord = true;
        }

    }

    NodeTrie root;

    public GFG_AutoComplete(List<String> words) {
        root = new NodeTrie();
        for (String word : words)
            root.insert(word);

    }

    public boolean find(String prefix, boolean exact) {
        NodeTrie lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord;
    }

    public boolean find(String prefix) {
        return find(prefix, false);
    }

    public void suggestHelper(NodeTrie root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }

        if (root.children == null || root.children.isEmpty())
            return;

        for (NodeTrie child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        NodeTrie lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }


    public static void main(String[] args) {
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel","help","helps","helping");
        GFG_AutoComplete GFGAutoComplete = new GFG_AutoComplete(words);

        System.out.println(GFGAutoComplete.suggest("hel"));
    }

}
