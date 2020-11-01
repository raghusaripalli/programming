package leetcode.november;

import leetcode.linked_list.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        StringBuffer sb = new StringBuffer();
        ListNode temp = head;
        while(temp!=null) {
            sb.append(temp.val);
            temp=temp.next;
        }
        int res = 0, pow = 1;
        for(int i=sb.length()-1; i>=0; i--) {
            if (sb.charAt(i) == '1')
                res += pow;
            pow *=2;
        }
        return res;
    }
}
