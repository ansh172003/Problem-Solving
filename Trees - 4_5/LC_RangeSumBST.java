public class LC_RangeSumBST {
        public int rangeSumBST(TreeNode root, int left, int right) {
            if (root == null) return 0;
            if (root.val < left) return rangeSumBST(root.right, left, right);
            if (root.val > right)  return rangeSumBST(root.left, left, right);


            return root.val + rangeSumBST(root.left, left, right) + rangeSumBST(root.right, left, right);
        }
}
