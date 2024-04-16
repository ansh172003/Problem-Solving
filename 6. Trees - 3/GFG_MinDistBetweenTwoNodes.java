class GfG_MinDistBetweenTwoNodes {
    TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b) return root;
        TreeNode leftLCA = findLCA(root.left, a, b);
        TreeNode rightLCA = findLCA(root.right, a, b);
        if (leftLCA != null && rightLCA != null) return root;
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    int findDistanceFromLCA(TreeNode root, int target, int distance) {
        if (root == null) return -1;

        if (root.val == target) return distance;

        int leftDistance = findDistanceFromLCA(root.left, target, distance + 1);
        if (leftDistance != -1) return leftDistance;

        return findDistanceFromLCA(root.right, target, distance + 1);
    }

    int findDist(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root, a, b);

        int distA = findDistanceFromLCA(lca, a, 0);
        int distB = findDistanceFromLCA(lca, b, 0);

        return distA + distB;
    }
}