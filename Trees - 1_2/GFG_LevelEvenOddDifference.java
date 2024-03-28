import java.util.*;

class GFG_LevelEvenOddDifference{
    int getLevelDiff(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int evenSum = 0, oddSum = 0;

        while (q.size() != 0) {
            int size = q.size();
            level++;
            while (size > 0) {
                TreeNode temp = q.remove();
                if (level % 2 == 0) evenSum += temp.val;
                else oddSum += temp.val;
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                size--;
            }
        }
        return (oddSum - evenSum);
    }
}