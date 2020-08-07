package leetcode.august_challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VerticalOrderTraversalOfBinaryTree {
    private List<int[]> list = new ArrayList<>();

    private List<List<Integer>> verticalTraversal(TreeNode root) {
        DFS(root, 0, 0);

        list.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    //sort based on X
                    return a[1] - b[1];
                } else if (a[2] != b[2]) {
                    //then Y, decreasing order
                    return -a[2] + b[2];
                } else {
                    //then value
                    return a[0] - b[0];
                }
            }
        });

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int j = i;

            while (j < list.size() && list.get(j)[1] == list.get(i)[1]) {
                j++;
            }

            List<Integer> temp = new ArrayList<>();

            for (int z = i; z < j; z++) {
                temp.add(list.get(z)[0]);
            }

            result.add(temp);
            i = j - 1;
        }

        return result;

    }

    private void DFS(TreeNode root, int x, int y) {
        if (root == null) return;
        list.add(new int[]{root.val, x, y});
        DFS(root.left, x - 1, y - 1);
        DFS(root.right, x + 1, y - 1);
    }


    public static void main(String[] args) {
        // test case 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversalOfBinaryTree vtbt = new VerticalOrderTraversalOfBinaryTree();
        List<List<Integer>> res = vtbt.verticalTraversal(root);
        res.forEach(x -> {
            x.forEach(y -> System.out.print(y + " "));
            System.out.println();
        });
    }
}
