package leetcode.binary_search;

import leetcode.may_april_june_challenge.Helper;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(Helper.parseIntegerArray("[1,3,5,6]"), 5) + " " +
                sip.searchInsert(Helper.parseIntegerArray("[1,3,5,6]"), 2) + " " +
                sip.searchInsert(Helper.parseIntegerArray("[1,3,5,6]"), 7) + " " +
                sip.searchInsert(Helper.parseIntegerArray("[1,3,5,6]"), 0)
        );
    }
}
