import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[] refund = new int[2 * N];
        int sum = 0, idx = 0;
        for (int[] cost : costs) {
            sum += cost[0];
            refund[idx++] = cost[1] - cost[0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < N; i++) {
            sum += refund[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoCityScheduling scheduling = new TwoCityScheduling();
        // Test Case: [[10,20],[30,200],[400,50],[30,20]] = 110
        int[][] costs = new int[4][2];
        costs[0][0] = 10;
        costs[0][1] = 20;
        costs[1][0] = 30;
        costs[1][1] = 200;
        costs[2][0] = 400;
        costs[2][1] = 50;
        costs[3][0] = 30;
        costs[3][1] = 20;
        int res = scheduling.twoCitySchedCost(costs);
        System.out.println(res);
    }
}
