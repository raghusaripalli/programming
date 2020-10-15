package leetcode.october;

import leetcode.may_april_june_challenge.Helper;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = Helper.parseIntegerArray("[1,2,3,4,5,6,7]");
        ra.rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
