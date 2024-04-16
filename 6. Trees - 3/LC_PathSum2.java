import java.util.*;
public class LC_PathSum2 {
    void dfs(TreeNode root, int sum, List<Integer> currPath, List<List<Integer>> allPaths) {
        if (root == null)
            return;
        if (root.val == sum && root.left == null && root.right == null) {
            currPath.add(root.val);
            allPaths.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }

        currPath.add(root.val);
        dfs(root.left, sum - root.val, currPath, allPaths);
        dfs(root.right, sum - root.val, currPath, allPaths);
        currPath.remove(currPath.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

}
