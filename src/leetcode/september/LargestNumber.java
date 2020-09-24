package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        if (strings.length > 0 && strings[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(Helper.parseIntegerArray("")));
        System.out.println(ln.largestNumber(Helper.parseIntegerArray("[0,0]")));
        System.out.println(ln.largestNumber(Helper.parseIntegerArray("[10,2]")));
        System.out.println(ln.largestNumber(Helper.parseIntegerArray("[3,30,34,5,9]")));
    }
}
