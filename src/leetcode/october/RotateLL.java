package leetcode.october;

import leetcode.linked_list.ListNode;

public class RotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode temp = head, prev = head;
        int len = 0;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            len++;
        }
        k %= len;
        if (len == 1 || 0 == k) {
            return head;
        }

        prev.next = head;
        int cut = len - k;
        temp = head;
        while (--cut > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateLL rl = new RotateLL();
        System.out.println(rl.rotateRight(new ListNode(1), 3).val);
    }
}
