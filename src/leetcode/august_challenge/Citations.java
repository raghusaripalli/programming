package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

import java.util.Arrays;

public class Citations {
    private int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= count)
                break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Citations citations = new Citations();
        System.out.println(citations.hIndex(Helper.parseIntegerArray("[3,0,6,1,5]"))); // 3
        System.out.println(citations.hIndex(Helper.parseIntegerArray("[10,4,3,5,8]"))); // 4
        System.out.println(citations.hIndex(Helper.parseIntegerArray("[25,8,5,3,3]"))); // 3
    }
}
