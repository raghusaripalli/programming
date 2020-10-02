package leetcode.october;

import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> res;
    private int[] candidates;
    private int target;
    private void helper(LinkedList<Integer> list, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        else if (sum < target) {
            while (index < candidates.length) {
                int item = candidates[index];
                list.add(item);
                helper(list, index, sum + item);
                list.removeLast();
                index++;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        helper(new LinkedList<>(), 0, 0);
        return res;
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(Helper.parseIntegerArray("[1]"), 1).forEach(Helper::prettyPrint);
        cs.combinationSum(Helper.parseIntegerArray("[1]"), 2).forEach(Helper::prettyPrint);
        cs.combinationSum(Helper.parseIntegerArray("[2]"), 1).forEach(Helper::prettyPrint);
        cs.combinationSum(Helper.parseIntegerArray("[2,3,5]"), 8).forEach(Helper::prettyPrint);
        cs.combinationSum(Helper.parseIntegerArray("[2,3,6,7]"), 7).forEach(Helper::prettyPrint);
    }
}
