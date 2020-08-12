package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle2 {

    private static final List<List<Integer>> pascalTriangle = new ArrayList<>(34);

    static {
        pascalTriangle.add(new ArrayList<>(Collections.singletonList(1)));
        pascalTriangle.add(new ArrayList<>(Arrays.asList(1, 1)));
        for (int i = 2; i < 34; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            List<Integer> prevRow = pascalTriangle.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            pascalTriangle.add(row);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return pascalTriangle.get(rowIndex);
    }

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        for (int i = 0; i < 34; i++) {
            Helper.prettyPrint(pascalTriangle2.getRow(i));
        }
    }
}
