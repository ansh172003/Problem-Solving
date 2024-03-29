public class LC_TreeDiameter {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        ans = Math.max(ans, l + r);
        return 1 + Math.max(l, r);
    }
}
