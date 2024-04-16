import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GFG_FindCommonNodes {
    void dfs(TreeNode root, Map<Integer, Integer> m) {
        if (root == null) return;
        m.put(root.val, m.getOrDefault(root.val, 0) + 1);
        dfs(root.left, m);
        dfs(root.right, m);
    }

    public ArrayList<Integer> findCommon(TreeNode A, TreeNode B) {
        Map<Integer, Integer> m = new HashMap<>();
        dfs(A, m);
        dfs(B, m);
        ArrayList<Integer> commonTreeNodes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() > 1) {
                commonTreeNodes.add(entry.getKey());
            }
        }
        Collections.sort(commonTreeNodes);
        return commonTreeNodes;
    }
}
