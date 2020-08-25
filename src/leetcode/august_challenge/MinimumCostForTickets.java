package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

public class MinimumCostForTickets {
    private int mincostTickets(int[] days, int[] costs) {
        Integer[] table = new Integer[days.length];
        return minCostTickets(days, costs, table, 0);
    }

    private int minCostTickets(int[] days, int[] costs, Integer[] table, int i) {
        if (i >= days.length)
            return 0;

        if (table[i] != null)
            return table[i];

        int index7 = i + 1, index30 = i + 1;
        while (index7 < days.length && days[index7] - days[i] < 7)
            index7++;
        while (index30 < days.length && days[index30] - days[i] < 30)
            index30++;

        table[i] = Math.min(minCostTickets(days, costs, table, i + 1) + costs[0],
                minCostTickets(days, costs, table, index7) + costs[1]);

        table[i] = Math.min(table[i], minCostTickets(days, costs, table, index30) + costs[2]);
        return table[i];
    }

    public static void main(String[] args) {
        MinimumCostForTickets mc = new MinimumCostForTickets();
        int[] days = Helper.parseIntegerArray("[1,4,6,7,8,20]");
        int[] costs = Helper.parseIntegerArray("[2,7,15]");
        System.out.println(mc.mincostTickets(days, costs));
        days = Helper.parseIntegerArray("[1,2,3,4,5,6,7,8,9,10,30,31]");
        System.out.println(mc.mincostTickets(days, costs));
    }
}