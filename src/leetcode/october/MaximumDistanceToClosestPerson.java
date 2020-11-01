package leetcode.october;

public class MaximumDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int globMax = 0, currMax = 0, i = 0;
        while (seats[i] == 0) {
            i++;
            currMax++;
        }
        globMax = Math.max(globMax, currMax);
        currMax = 1;
        while (i < seats.length) {
            if (seats[i] == 1) {
                globMax = Math.max(globMax, currMax / 2);
                currMax = 0;
            }
            currMax++;
            i++;
        }
        return Math.max(globMax, currMax - 1);
    }

    public static void main(String[] args) {
        MaximumDistanceToClosestPerson md = new MaximumDistanceToClosestPerson();
        System.out.println(md.maxDistToClosest(new int[]{0, 1}));
        System.out.println(md.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(md.maxDistToClosest(new int[]{0, 0, 0, 1, 0}));
        System.out.println(md.maxDistToClosest(new int[]{1, 0}));
        System.out.println(md.maxDistToClosest(new int[]{0, 0, 1, 1, 0, 0, 0, 0}));
    }
}
