package leetcode.contest_192;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int size = nums.length;
        int[] res = new int[size];
        int i = 0, j = n, k = 0;
        while (i < n) {
            res[k++] = nums[i++];
            res[k++] = nums[j++];
        }
        return res;
    }
}
