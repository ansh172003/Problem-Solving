public class LC_MakeBSTfromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }

    TreeNode makeBST(int[] nums, int l, int r){
        if(l > r) return null;

        int m = (l + r) / 2;
        TreeNode x = new TreeNode(nums[m]);

        x.left = makeBST(nums, l, m- 1);
        x.right = makeBST(nums, m + 1, r);

        return x;
    }
}
