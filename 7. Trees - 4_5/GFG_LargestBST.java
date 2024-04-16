public class GFG_LargestBST {
    static class NodeData {
        public int maxVal, minVal, ans;
        public boolean isBST;

        NodeData(int maxVal, int minVal, boolean isBST,  int ans) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.ans = ans;
            this.isBST = isBST;
        }

        NodeData() {
            this.maxVal = Integer.MIN_VALUE;
            this.minVal = Integer.MAX_VALUE;
            this.isBST = true;
            this.ans = 0;
        }
    }
    static NodeData findLargestBST(TreeNode root, int[] sol) {
        if(root == null) return new NodeData();

        NodeData l = findLargestBST(root.left, sol);
        NodeData r = findLargestBST(root.right, sol);

        int minX = Math.min(root.val, Math.min(l.minVal, r.minVal));
        int maxX = Math.max(root.val, Math.max(l.maxVal, r.maxVal));

        boolean BST =  (l.isBST && r.isBST && root.val > l.maxVal && root.val < r.minVal);

        int s = BST?l.ans + r.ans + 1 : 0;
        sol[0] = Math.max(sol[0], s);
        return new NodeData(maxX, minX, BST, s);

    }
    static int largestBst(TreeNode root){
        if(root == null) return 0;
        int[] maxS = new int[1];
        findLargestBST(root, maxS);
        return maxS[0];
    }
}
