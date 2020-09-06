package leetcode.linked_list;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node != null) {
            ListNode nextNode = node.next;
            if (nextNode == null) {
                node = null;
            } else {
                int val = nextNode.val;
                node.next = nextNode.next;
                node.val = val;
            }
        }
    }

    public static void main(String[] args) {
        DeleteNodeInLinkedList dn = new DeleteNodeInLinkedList();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        dn.deleteNode(head);
        System.out.println(head.val);
    }
}
