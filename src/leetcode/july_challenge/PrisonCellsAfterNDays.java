package leetcode.july_challenge;

import leetcode.Helper;

import java.util.ArrayList;
import java.util.List;

public class PrisonCellsAfterNDays {
    private List<int[]> arr = new ArrayList<>();

    private int[] prisonAfterNDays(int[] cells, int N) {
        if (N % 14 == 0 && N != 0) N = 14;
        else N = N % 14;

        while (N-- != 0) {
            int[] res = new int[cells.length];
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) res[i] = 0;
                else if (i == cells.length - 1) res[i] = 0;
                else if (cells[i - 1] == cells[i + 1]) res[i] = 1;
                else res[i] = 0;
            }
            System.arraycopy(res, 0, cells, 0, cells.length);
        }
        return cells;
    }

    public static void main(String[] args) {
        PrisonCellsAfterNDays days = new PrisonCellsAfterNDays();
        // Test Case 1 - cells = [0,1,0,1,1,0,0,1], N = 7
        int N = 35;
        for (int i = 0; i < N; i++) {
            int[] cells = Helper.parseIntegerArray("[1,0,0,1,0,0,1,0]");
            int[] res = days.prisonAfterNDays(cells, i);
            System.out.print(i + ": ");
            for (int re : res) {
                System.out.print(re + " ");
            }
            int idx = days.match(res);
            if (idx != -1) System.out.println("-Match Found at " + idx);
            else System.out.println();
        }
    }

    private int match(int[] res) {
        int count = -1;
        for (int[] ints : arr) {
            count++;
            boolean flag = true;
            for (int i = 0; i < ints.length; i++) {
                if (res[i] != ints[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return count;
        }
        arr.add(res);
        return -1;
    }
}
