package leetcode.october;

import leetcode.may_april_june_challenge.Helper;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int mid, lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = Helper.parseIntegerArray("[-1,0,3,5,9,12]");
        System.out.println(bs.search(nums, -2));
        for (int num : nums) {
            System.out.println(bs.search(nums, num));
        }
        System.out.println(bs.search(nums, 14));
    }
}
