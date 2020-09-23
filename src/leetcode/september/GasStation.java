package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

public class GasStation {
    private int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return (total + tank < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int[] gas = Helper.parseIntegerArray("[1,2,3,4,5]");
        int[] cost = Helper.parseIntegerArray("[3,4,5,1,2]");
        System.out.println(gs.canCompleteCircuit(gas, cost));

        gas = Helper.parseIntegerArray("[2,3,4]");
        cost = Helper.parseIntegerArray("[3,4,3]");
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
