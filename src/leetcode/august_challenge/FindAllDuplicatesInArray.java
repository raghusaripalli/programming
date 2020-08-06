package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    private List<Integer> findDuplicates(int[] nums) {
        int[] arr = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (arr[num] != 0) {
                res.add(num);
            } else {
                arr[num]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInArray fada = new FindAllDuplicatesInArray();
        int[] input = Helper.parseIntegerArray("[4,3,2,7,8,2,3,1]");
        List<Integer> res;
        res = fada.findDuplicates(input);
        res.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

}
