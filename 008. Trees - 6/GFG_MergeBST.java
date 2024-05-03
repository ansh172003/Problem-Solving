import java.util.*;

public class GFG_MergeBST {
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> mergedList = new ArrayList<>();
        inorderTraversal(root1, mergedList);
        inorderTraversal(root2, mergedList);
        mergedList.sort(null);
        return mergedList;
    }

    void inorderTraversal(Node root, List<Integer> list) {
        if (root != null) {
            inorderTraversal(root.left, list);
            list.add(root.data);
            inorderTraversal(root.right, list);
        }
    }
}
