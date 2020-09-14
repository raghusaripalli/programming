package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

public class HouseRobber {
    private int rob(int[] nums) {
        int N = nums.length;
        if (N == 0)
            return 0;
        if (N == 1)
            return nums[0];

        int[] ans = new int[N];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < N; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return ans[N - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(Helper.parseIntegerArray("[2,1,1,2]")));
    }
}
