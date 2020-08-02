package leetcode.may_april_june_challenge;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length, mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return low < nums.length && target > nums[low] ? low + 1 : low;
    }

    public static void main(String[] args) {
        SearchInsertPosition pos = new SearchInsertPosition();
        int[] arr = new int[5];
        arr[0] = 0;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 10;
        for (int i = 0; i < 14; i++)
            System.out.println(i + "," + pos.searchInsert(arr, i));
    }
}
