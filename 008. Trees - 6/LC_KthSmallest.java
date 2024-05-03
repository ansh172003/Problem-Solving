public class LC_KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        final int lCounter = nodeCounter(root.left);
        if (lCounter == k - 1) return root.val;
        if (lCounter >= k) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - 1 - lCounter);
    }
    int nodeCounter(TreeNode root) {
        if (root == null) return 0;
        return 1 + nodeCounter(root.left) + nodeCounter(root.right);
    }
}
