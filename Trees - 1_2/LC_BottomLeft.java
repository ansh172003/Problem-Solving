class LC_BottomLeft {
    int ans = 0;
    int maxDepth = 0;
    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }
}