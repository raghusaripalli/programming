package leetcode;

// Reference: https://en.wikipedia.org/wiki/Dutch_national_flag_problem

public class SortColors {

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, white, red);
                white += 1;
                red += 1;
            } else if (nums[white] == 1) {
                white += 1;
            } else {
                swap(nums, white, blue);
                blue -= 1;
            }
        }
    }

    public static void main(String[] args) {
        SortColors colors = new SortColors();
        int[] nums = new int[6];
        nums[0] = 2;
        nums[2] = 2;
        nums[3] = 1;
        nums[4] = 1;
        colors.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
