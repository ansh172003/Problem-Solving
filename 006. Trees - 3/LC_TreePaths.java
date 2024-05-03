import java.util.*;
class LC_TreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder temp, List<String> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(temp.append(root.val).toString());
            return;
        }

        final int length = temp.length();
        dfs(root.left, temp.append(root.val).append("->"), ans);
        temp.setLength(length);
        dfs(root.right, temp.append(root.val).append("->"), ans);
        temp.setLength(length);
    }
}