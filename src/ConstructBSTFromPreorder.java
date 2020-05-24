import java.util.Stack;

public class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        // Pre order [root, left, right]
        int size = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]), temp;
        stack.push(root);
        for (int i = 1; i < size; i++) {
            temp = null;

            while (!stack.empty() && preorder[i] > stack.peek().val) {
                // pop until entering stack having value less than top element
                temp = stack.pop();
            }

            if (temp != null) { // if temp is having value means, found a right node in tree
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            } else { // if temp is null means, found a left node in tree
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ConstructBSTFromPreorder cb = new ConstructBSTFromPreorder();
        // Test Case - [8,5,1,7,10,12]
        int[] arr = new int[6];
        arr[0] = 8;
        arr[1] = 5;
        arr[2] = 1;
        arr[3] = 7;
        arr[4] = 10;
        arr[5] = 12;
        TreeNode res = cb.bstFromPreorder(arr);
    }
}
