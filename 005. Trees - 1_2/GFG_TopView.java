import java.util.*;

class Pair{
    TreeNode data;
    int level;
    Pair(TreeNode _data, int _level){
        data = _data;
        level = _level;
    }
}

class GFG_TopView{

    static ArrayList<Integer> topView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair x = q.remove();
            int level = x.level;
            TreeNode data = x.data;
            if(map.get(level) == null) map.put(level, data.val);
            if(data.left != null) {

                q.add(new Pair(data.left, level - 1));
            }
            if(data.right != null) {

                q.add(new Pair(data.right, level + 1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }
}
