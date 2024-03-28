import java.util.*;
class LC_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        preOrder(root,0,list);
        return list;
    }
    public void preOrder(TreeNode root,int level,List<List<Integer>> list){
        if(root==null)
            return;

        if(level==list.size()){
            List<Integer> subList=new ArrayList<>();
            subList.add(root.val);
            list.add(subList);
        }
        else
            list.get(level).add(root.val);

        preOrder(root.left,level+1,list);
        preOrder(root.right,level+1,list);
    }

}