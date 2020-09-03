package leetcode.linked_list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        ListNode cur = head, nth = head, n1th = null;
        while (--n > 0) {
            cur = cur.next;
        }

        while (cur.next != null) {
            n1th = nth;
            nth = nth.next;
            cur = cur.next;
        }
        if (n1th == null) {
            head = head.next;
        } else {
            n1th.next = nth.next;
        }
        return head;
    }


}
