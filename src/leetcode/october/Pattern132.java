package leetcode.october;

import leetcode.may_april_june_challenge.Helper;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        boolean asc = false, desc = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                desc = true;
                if (asc) {
                    return true;
                }
            } else if (nums[i] > nums[i-1]){
                asc = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pattern132 p123 = new Pattern132();
        System.out.println(p123.find132pattern(Helper.parseIntegerArray("[1,2,3,4]")));
        System.out.println(p123.find132pattern(Helper.parseIntegerArray("[3,1,4,2]")));
        System.out.println(p123.find132pattern(Helper.parseIntegerArray("[-1,3,2,0]")));
        System.out.println(p123.find132pattern(Helper.parseIntegerArray("[1,0,1,-4,-3]")));
        System.out.println(p123.find132pattern(Helper.parseIntegerArray("[1]")));
        System.out.println(p123.find132pattern(Helper.parseIntegerArray("[2,1]")));
    }
}
