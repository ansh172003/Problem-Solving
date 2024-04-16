public class GFG_FindCeil {
    int findCeil(TreeNode root, int key) {
        if (root == null) return -1;

        if(root.val == key) return root.val;

        if(root.val < key) return findCeil(root.right, key);

        int c = findCeil(root.left, key);

        if(c>=key) return c;
        else return root.val;
    }
}
