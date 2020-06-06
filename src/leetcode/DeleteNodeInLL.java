package leetcode;// Problem Statement: https://leetcode.com/problems/delete-node-in-a-linked-list/

public class DeleteNodeInLL {
    private ListNode root;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode createList() {
        root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);
        return root.next.next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNodeInLL ll = new DeleteNodeInLL();
        // test Case - 4 5 1 9, node = 1
        ll.deleteNode(ll.createList());
        ListNode head = ll.root;
        while (head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
