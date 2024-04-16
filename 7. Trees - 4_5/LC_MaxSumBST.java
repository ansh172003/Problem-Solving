class NodeData {
    public boolean isBST;
    public Integer maxVal;
    public Integer minVal;
    public Integer ans;
    public NodeData() {
        this.isBST = false;
        this.maxVal = null;
        this.minVal = null;
        this.ans = null;
    }
    public NodeData(boolean isBST, int maxVal, int minVal, int ans) {
        this.isBST = isBST;
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.ans = ans;
    }
}

class LC_MaxSumBST {
    int finalSum = 0;

    public int maxSumBST(TreeNode root) {
        findSumBST(root);
        return finalSum;
    }


    NodeData findSumBST(TreeNode root) {
        if (root == null) return new NodeData(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeData l = findSumBST(root.left);
        NodeData r = findSumBST(root.right);

        if (!l.isBST || !r.isBST) return new NodeData();
        if (root.val <= l.maxVal || root.val >= r.minVal)  return new NodeData();
        int sum = root.val + l.ans + r.ans;
        finalSum = Math.max(finalSum, sum);
        return new NodeData(true, Math.max(root.val, r.maxVal), Math.min(root.val, l.minVal), sum);
    }
}