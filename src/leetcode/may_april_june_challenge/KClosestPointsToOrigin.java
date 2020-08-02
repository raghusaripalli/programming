package leetcode.may_april_june_challenge;

import java.util.PriorityQueue;

// Problem Statement: https://leetcode.com/problems/k-closest-points-to-origin/
// Sort, Heap, Divide and Conquer

public class KClosestPointsToOrigin {

    public int findDistanceFromOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    class Distance {
        int x, y, distance;

        Distance(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Distance> minHeap = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        for (int[] point : points) {
            minHeap.add(new Distance(point[0], point[1], findDistanceFromOrigin(point)));
        }
        int i = 0;
        int[][] res = new int[Math.min(K, points.length)][2];
        Distance distance;
        while (i < K && !minHeap.isEmpty()) {
            distance = minHeap.poll();
            res[i][0] = distance.x;
            res[i][1] = distance.y;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin pointsToOrigin = new KClosestPointsToOrigin();
        // test Case - points = [[3,3],[5,-1],[-2,4]], K = 2
        int points[][] = new int[3][2];
        points[0][0] = 3;
        points[0][1] = 3;
        points[1][0] = 5;
        points[1][1] = -1;
        points[2][0] = -2;
        points[2][1] = 4;
        int[][] res = pointsToOrigin.kClosest(points, 2);
        for (int[] point : res) {
            System.out.println(point[0] + "," + point[1]);
        }
    }
}
