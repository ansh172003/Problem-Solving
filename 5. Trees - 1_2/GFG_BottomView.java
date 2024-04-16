import java.util.*;
class GFG_BottomView{
    public ArrayList <Integer> bottomView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        root.val = 0;
        q.add(root);

        Map<Integer, Integer> treeMap = new TreeMap<>();

        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            int hd = temp.val;
            treeMap.put(hd, temp.val);
            if(temp.left != null) {
                temp.left.val = hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.val = hd + 1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}