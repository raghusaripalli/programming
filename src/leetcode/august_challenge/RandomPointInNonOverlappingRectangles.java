package leetcode.august_challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangles {

    // Memory Limit Exceeded - For Large Integer Ranges
    static class Solution1 {
        private final List<int[]> res;
        private int index;

        public Solution1(int[][] rects) {
            int l = rects.length;
            index = 0;
            res = new ArrayList<>(l * 2);
            int x1, y1, x2, y2;
            for (int[] rect : rects) {
                x1 = rect[0];
                y1 = rect[1];
                x2 = rect[2];
                y2 = rect[3];

                for (int i = y1; i <= y2; i++) {
                    for (int j = x1; j <= x2; j++) {
                        res.add(new int[]{j, i});
                    }
                }
            }

            for (int[] re : res) {
                System.out.println(re[0] + "," + re[1]);
            }
        }

        public int[] pick() {
            return res.get((index++) % res.size());
        }
    }

    static class Solution {

        int[][] arr;
        Random random;
        TreeMap<Integer, Integer> map;
        int sum;

        public Solution(int[][] rects) {
            random = new Random();
            arr = rects;
            map = new TreeMap<>();
            sum = 0;

            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                map.put(sum, i);
            }
        }

        public int[] pick() {
            int num = map.ceilingKey(random.nextInt(sum) + 1);
            int[] xy = arr[map.get(num)];
            return new int[]{xy[0] + random.nextInt(xy[2] - xy[0] + 1), xy[1] + random.nextInt(xy[3] - xy[1] + 1)};
        }
    }

    public static void main(String[] args) {
        int[][] rects1 = new int[1][4];
        rects1[0][0] = 1;
        rects1[0][1] = 1;
        rects1[0][2] = 5;
        rects1[0][3] = 5;
        Solution s1 = new Solution(rects1);
    }
}
