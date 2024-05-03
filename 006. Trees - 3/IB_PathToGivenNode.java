import java.util.*;

public class IB_PathToGivenNode {
    private boolean findPath(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) return false;

        path.add(root.val);

        if (root.val == target) return true;

        if (findPath(root.left, target, path) || findPath(root.right, target, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }

    // Main function to get the path to the target node
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();
        findPath(A, B, path);
        return path;
    }
}
