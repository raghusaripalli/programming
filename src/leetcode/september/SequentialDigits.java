package leetcode.september;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                num = num * 10 + nums[j];
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        SequentialDigits sd = new SequentialDigits();
        System.out.println(sd.sequentialDigits(10, 1000000000));
    }
}
