package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private List<List<Integer>> target;

    private void combinations(List<Integer> comb, int k, int n, int start) {
        if (k == comb.size()) {
            if (n == 0) target.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combinations(comb, k, n - i, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    private List<List<Integer>> combinationSum3(int k, int n) {
        target = new ArrayList<>();
        combinations(new ArrayList<>(), k, n, 1);
        return target;
    }

    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        List<List<Integer>> res = cs3.combinationSum3(3, 9);
        for (List<Integer> re : res) {
            Helper.prettyPrint(re);
        }
        res = cs3.combinationSum3(2, 7);
        for (List<Integer> re : res) {
            Helper.prettyPrint(re);
        }
    }
}
