package leetcode.trees;

import leetcode.august_challenge.TreeNode;
import leetcode.may_april_june_challenge.Helper;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/631/
public class SortedArrHeightBalancedBST {
    private TreeNode helper(int[] nums, int start, int end) {
        if (start <= end) {
            TreeNode root = new TreeNode();
            int mid = start + (end - start) / 2;
            root.val = nums[mid];
            root.left = helper(nums, start, mid - 1);
            root.right = helper(nums, mid + 1, end);
            return root;
        }
        return null;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        SortedArrHeightBalancedBST sa = new SortedArrHeightBalancedBST();
        BTLevelOrder bt = new BTLevelOrder();
        bt.levelOrder(sa.sortedArrayToBST(Helper.parseIntegerArray(""))).forEach(Helper::prettyPrint);
        bt.levelOrder(sa.sortedArrayToBST(Helper.parseIntegerArray("[0]"))).forEach(Helper::prettyPrint);
        bt.levelOrder(sa.sortedArrayToBST(Helper.parseIntegerArray("[3,5,8]"))).forEach(Helper::prettyPrint);
        bt.levelOrder(sa.sortedArrayToBST(Helper.parseIntegerArray("[-10,-3,0,5,9]"))).forEach(Helper::prettyPrint);
    }
}
