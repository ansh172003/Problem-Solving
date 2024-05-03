public class GFG_BSTtoCDLL {
    Node prev=null;
    Node bTreeToList(Node root){
        if(root==null) return null;
        Node head = bTreeToList(root.left);
        if(prev==null) head=root;
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        bTreeToList(root.right);
        return head;
    }
    Node bTreeToCList(Node root){
        if(root==null) return null;
        if(root.right==null && root.left==null){
            root.right=root;
            root.left=root;
            return root;
        }
        Node head= bTreeToList(root);
        Node curr=head;
        while(curr.right!=null){
            curr=curr.right;
        }
        curr.right=head;
        head.left=curr;
        return head;
    }

}
