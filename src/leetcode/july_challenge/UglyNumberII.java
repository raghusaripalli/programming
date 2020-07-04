package leetcode.july_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UglyNumberII {

    private List<Integer> uglyList = null;

    private void pre() {
        if (uglyList != null) return;
        uglyList = new ArrayList<>(Arrays.asList(new Integer[1691]));
        int t2 = 0, t3 = 0, t5 = 0;
        uglyList.set(0, 1);
        for (int i = 1; i < 1691; i++) {
            uglyList.set(i, Math.min(uglyList.get(t2) * 2, Math.min(uglyList.get(t3) * 3, uglyList.get(t5) * 5)));
            if (uglyList.get(i) == uglyList.get(t2) * 2) t2++;
            if (uglyList.get(i) == uglyList.get(t3) * 3) t3++;
            if (uglyList.get(i) == uglyList.get(t5) * 5) t5++;
        }
    }

    public int nthUglyNumber(int n) {
        pre();
        return uglyList.get(n - 1);
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        int res;
        for (int i = 1; i <= 1690; i++) {
            res = uglyNumberII.nthUglyNumber(i);
            System.out.print(res + " ");
        }
    }
}