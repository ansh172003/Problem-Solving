import java.util.ArrayList;
import java.util.List;


public class NK_BoundaryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.add(root.val);
            leftTraversal(root.left, result);
            leaveTraversal(root.left, result);
            leaveTraversal(root.right, result);
            rightTraversal(root.right, result);
        }

        return result;
    }

    private static void leftTraversal(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        result.add(node.val);
        if (node.left != null) {
            leftTraversal(node.left, result);
        } else {
            leftTraversal(node.right, result);
        }
    }

    private static void rightTraversal(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        if (node.right != null) {
            rightTraversal(node.right, result);
        } else {
            rightTraversal(node.left, result);
        }
        result.add(node.val);
    }

    private static void leaveTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        leaveTraversal(node.left, result);
        leaveTraversal(node.right, result);
    }
}
