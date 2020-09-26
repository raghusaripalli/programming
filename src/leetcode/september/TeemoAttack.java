package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

public class TeemoAttack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            res += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return res + duration;
    }

    public static void main(String[] args) {
        TeemoAttack ta = new TeemoAttack();
        System.out.println(ta.findPoisonedDuration(Helper.parseIntegerArray(""), 2));
        System.out.println(ta.findPoisonedDuration(Helper.parseIntegerArray("[1]"), 2));
        System.out.println(ta.findPoisonedDuration(Helper.parseIntegerArray("[1,4]"), 2));
        System.out.println(ta.findPoisonedDuration(Helper.parseIntegerArray("[1,2]"), 2));
    }
}
