package leetcode.august_challenge;

import leetcode.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        List<ListNode> temp = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            temp.add(t);
            t = t.next;
        }
        ListNode h = head;
        int l = temp.size();
        int i;
        for (i = 0; i < l / 2; i++) {
            h.next = temp.get(i);
            h = h.next;
            h.next = temp.get(l - 1 - i);
            h = h.next;
        }
        if (l % 2 != 0) {
            h.next = temp.get(i);
            h.next.next = null;
        } else {
            h.next = null;
        }
    }
}
