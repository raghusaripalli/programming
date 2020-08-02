package leetcode.may_april_june_challenge;

import java.util.ArrayList;

// Problem Statement: https://leetcode.com/problems/interval-list-intersections/

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);
            if (low <= high)
                res.add(new int[]{low, high});
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        IntervalListIntersections intersections = new IntervalListIntersections();
        // Test Case 1
        int[][] test1A = new int[4][4];
        int[][] test1B = new int[4][4];
        for (int i = 0; i < 4; i++) {
            test1A[i] = new int[2];
            test1B[i] = new int[2];
        }
        test1A[0][0] = 0;
        test1A[0][1] = 2;
        test1A[1][0] = 5;
        test1A[1][1] = 10;
        test1A[2][0] = 13;
        test1A[2][1] = 23;
        test1A[3][0] = 24;
        test1A[3][1] = 25;
        test1B[0][0] = 1;
        test1B[0][1] = 5;
        test1B[1][0] = 8;
        test1B[1][1] = 12;
        test1B[2][0] = 15;
        test1B[2][1] = 24;
        test1B[3][0] = 25;
        test1B[3][1] = 26;
        int[][] res = intersections.intervalIntersection(test1A, test1B);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        /*
            Test Case 2 (edge case)
            A = [[3,5],[9,20]]
            B = [[4,5],[7,10],[11,12],[14,15],[16,20]]

            Test Case 3 (exchange A and B in Test Case 1 and 2)
         */
    }
}
