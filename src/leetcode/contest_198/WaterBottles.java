package leetcode.contest_198;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;
        int count = 0;
        while (numBottles >= numExchange) {
            count += numExchange;
            numBottles = numBottles - numExchange + 1;
        }
        return count + numBottles;
    }

    public static void main(String[] args) {
        WaterBottles wb = new WaterBottles();
        System.out.println(wb.numWaterBottles(9, 3));
        System.out.println(wb.numWaterBottles(15, 4));
        System.out.println(wb.numWaterBottles(5, 5));
        System.out.println(wb.numWaterBottles(2, 3));
    }
}
