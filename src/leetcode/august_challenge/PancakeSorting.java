package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public int gett(int[] A, int i) {
        int temp = 0;
        int maxv = A[0];
        for (int j = 0; j < i; j++) {
            if (A[j] > maxv) {
                maxv = A[j];
                temp = j;
            }
        }
        return temp;
    }

    public void reverse(int[] a, int k) {
        for (int i = 0; i < k / 2; i++) {
            int tempswap = a[i];
            a[i] = a[k - i - 1];
            a[k - i - 1] = tempswap;
        }
    }

    public List<Integer> pancakeSort(int[] A) {

        List<Integer> ans = new ArrayList<>();
        for (int i = A.length; i > 1; i--) {
            int temp = gett(A, i);
            if (temp != i - 1) {
                reverse(A, temp + 1);
                ans.add(temp + 1);
                reverse(A, i);
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PancakeSorting ps = new PancakeSorting();
        Helper.prettyPrint(ps.pancakeSort(Helper.parseIntegerArray("[3,2,4,1]")));
        Helper.prettyPrint(ps.pancakeSort(Helper.parseIntegerArray("[1,2,3]")));
    }
}
