public class LC_PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) return 0;

        if(sum == root.val){
            return 1 + dfs(root.left, 0) + dfs(root.right, sum-root.val);
        }
        else {
            return dfs(root.left, sum-root.val) + dfs(root.right, sum-root.val);
        }
    }

}
