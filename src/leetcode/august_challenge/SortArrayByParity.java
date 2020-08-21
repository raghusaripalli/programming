package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] a) {
        int r = a.length - 1;
        int l = 0;
        int temp;
        while (l < r) {
            if (a[l] % 2 == 0) {
                l++;
            } else if (a[r] % 2 != 0) {
                r--;
            } else {
                temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        SortArrayByParity sab = new SortArrayByParity();
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[0]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[1]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[1,1]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[1,2]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[1,3]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[2,4,6]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[1,3,6]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[2,5,6]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[2,4,1,3]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[3,1,2,4]"))));
        System.out.println(Arrays.toString(sab.sortArrayByParity(Helper.parseIntegerArray("[1,3,5,10,12]"))));
    }
}
