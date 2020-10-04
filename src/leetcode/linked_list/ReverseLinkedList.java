package leetcode.linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        rll.reverseList(new ListNode());
        rll.reverseList(new ListNode(1));
    }
}
