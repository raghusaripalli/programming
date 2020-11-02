package leetcode.november;

import leetcode.linked_list.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode i = head, j;
        while (i != null) {
            j = head;
            while (j != i && j.val < i.val) {
                j = j.next;
            }
            int a = i.val, b;
            while (j != i) {
                b = j.val;
                j.val = a;
                a = b;
                j = j.next;
            }
            j.val = a;

            i = i.next;
        }
        return head;
    }
}
