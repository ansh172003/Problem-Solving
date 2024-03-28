import java.util.*;

class levelData{
    TreeNode node;
    int row;
    int col;
    public levelData(TreeNode n, int r, int c){
        node = n;
        row = r;
        col = c;
    }

}
class  LC_verticalOrder{
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<levelData> q = new LinkedList<levelData>();
        q.offer(new levelData(root, 0 ,0));
        while(!q.isEmpty()){
            levelData ld = q.poll();
            TreeNode node = ld.node;
            int x = ld.row;
            int y = ld.col;

            if(!map.containsKey(x)) map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue <> ());
            map.get(x).get(y).offer(node.val);
            if (node.left != null) q.offer(new levelData(node.left, x - 1, y + 1));
            if (node.right != null) q.offer(new levelData(node.right, x + 1, y + 1));
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
