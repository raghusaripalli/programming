import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] < B[j][0]) { // A started before
                // A end didn't touch B start
                if (A[i][1] < B[j][0]) i++; // then we can go to next item in A
                else if (A[i][1] == B[j][0]) { // A end equals B start
                    temp.add(A[i][1]); // Both the elements will be same
                    temp.add(B[j][0]);
                    i++;
                } else { // A end is after B start
                    // A end can be less, equal or more than B end
                    temp.add(B[j][0]); // B start
                    if (A[i][1] >= B[j][1]) { // A end same or after B end
                        temp.add(B[j][1]);
                        if (A[i][1] == B[j][1]) i++; // If ends are equal move A to next item
                        j++; // B is fully in A, so move B to next item
                    }
                    else { // A end is Before B end
                        temp.add(A[i][1]);
                        i++; // Add a end and Move A to next item
                    }
                }
            } else { // B started before
                // B end didn't touch A start
                if (B[j][1] < A[i][0]) j++; // then we can go to next item in B
                else if (B[j][1] == A[i][0]) { // B end equals A start
                    temp.add(B[j][1]); // Both the elements will be same
                    temp.add(A[i][0]);
                    j++;
                } else { // B end is after A start
                    // B end can be less, equal or more than A end
                    temp.add(A[i][0]); // A start
                    if (B[j][1] >= A[i][1]) { // B end same or after A end
                        temp.add(A[i][1]);
                        if (B[j][1] == A[i][1]) j++; // If ends are equal move B to next item
                        i++; // A is fully in B, so move A to next item
                    }
                    else { // B end is Before A end
                        temp.add(B[j][1]);
                        j++; // Add B end and Move B to next item
                    }
                }
            }
        }
        int size = temp.size()/2;
        int[][] res = new int[size][];
        int idx = 0;
        for (int k = 0; k < size; k++) res[k] = new int[2];
        for (int k = 0; k < size; k++) {
            res[k][0] = temp.get(idx++);
            res[k][1] = temp.get(idx++);
        }
        return res;
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
    }
}
