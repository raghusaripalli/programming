package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight height = new QueueReconstructionByHeight();
        // Test Case - [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        // res = [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

        int[][] people = new int[6][2];
        people[0][0] = 7;
        people[1][0] = 4;
        people[1][1] = 4;
        people[2][0] = 7;
        people[2][1] = 1;
        people[3][0] = 5;
        people[4][0] = 6;
        people[4][1] = 1;
        people[5][0] = 5;
        people[5][1] = 2;

        int[][] res = height.reconstructQueue(people);

        for (int[] r: res) {
            System.out.println(r[0]+","+r[1]);
        }
    }
}
