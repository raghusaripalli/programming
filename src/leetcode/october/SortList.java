package leetcode.october;

import leetcode.linked_list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.val = arr.get(i++);
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode res = sl.sortList(new ListNode());
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }

}
