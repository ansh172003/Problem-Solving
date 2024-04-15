class LC_RecoverBST{
    public void recoverTree(TreeNode root) {
        traverse(root);
        swap(first, second);
    }
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (prev != null && root.val < prev.val) {
            second = root;
            if (first == null)
                first = prev;
            else
                return;
        }
        prev = root;

        traverse(root.right);
    }

    void swap(TreeNode x, TreeNode y) {
        final int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}