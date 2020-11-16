package leetcode.november;

import leetcode.may_april_june_challenge.Helper;

public class LongestMountaininArray {
    public int longestMountain(int[] A) {
        int len = A.length;
        if (len <= 2) {
            return 0;
        }
        int[] frontdp = new int[A.length];
        int[] backdp = new int[A.length];

        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1]) {
                frontdp[i] = frontdp[i - 1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                backdp[i] = backdp[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (frontdp[i] > 0 && backdp[i] > 0)
                res = Math.max(res, frontdp[i] + backdp[i] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestMountaininArray lm = new LongestMountaininArray();
        System.out.println(lm.longestMountain(Helper.parseIntegerArray("[2,1,4,7,3,2,5,7,9,10,8,6,4,3,2,6,7,8,2,0]")));
    }
}
