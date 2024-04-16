public class LC_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }
    boolean checkBST(TreeNode root, TreeNode left, TreeNode right){
        if(root == null) return true;
        if(left != null && left.val >= root.val) return false;
        if(right != null && right.val <= root.val) return false;

        return checkBST(root.left, left, root) && checkBST(root.right, root, right);
    }
}
