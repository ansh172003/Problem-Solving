import java.util.HashMap;
import java.util.Map;

public class LC_TwoSum4 {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return DFS(root, map, k);
    }

    boolean DFS(TreeNode root, Map<Integer, Integer> map, int k) {
        if (root == null) return false;
        if (map.containsKey(k - root.val)) return true;
        map.put(root.val, 1);
        return DFS(root.left, map, k) || DFS(root.right, map, k);
    }
}
