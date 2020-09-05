package leetcode.september;

import leetcode.august_challenge.TreeNode;
import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBSTs {
    private void inOrder(TreeNode root, List<Integer> arr) {
        if (root != null) {
            inOrder(root.left, arr);
            arr.add(root.val);
            inOrder(root.right, arr);
        }
    }

    private List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        if (arr1.size() == 0)
            return arr2;
        if (arr2.size() == 0)
            return arr1;
        int idx1 = 0, idx2 = 0;
        while (idx1 < arr1.size() && idx2 < arr2.size()) {
            if (arr1.get(idx1) <= arr2.get(idx2)) {
                idx1++;
            } else {
                arr1.add(idx1, arr2.get(idx2));
                idx1++;
                idx2++;
            }
        }
        while (idx2 < arr2.size()) {
            arr1.add(arr2.get(idx2++));
        }
        return arr1;
    }

    private List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sorted1 = new ArrayList<>();
        inOrder(root1, sorted1);
        List<Integer> sorted2 = new ArrayList<>();
        inOrder(root2, sorted2);
        return merge(sorted1, sorted2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        AllElementsInTwoBSTs ae = new AllElementsInTwoBSTs();
        Helper.prettyPrint(ae.getAllElements(root1, root2));
    }

}
