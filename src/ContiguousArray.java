import java.util.HashMap;

// Problem Statement: https://leetcode.com/problems/contiguous-array/

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, -1);

        int max_length = 0;
        int counts = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counts -= 1;
            } else {
                counts += 1;
            }

            if (count.containsKey(counts)) {
                max_length = Math.max(max_length, i - count.get(counts));
            } else {
                count.put(counts, i);
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        // Test Case - [0, 1, 0] = 2
        int[] nums = new int[3];
        nums[1] = 1; // Already 0, 2 are instantiated with zeros
        int res = ca.findMaxLength(nums);
        System.out.println(res);
    }
}
