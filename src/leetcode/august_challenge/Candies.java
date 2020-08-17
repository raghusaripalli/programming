package leetcode.august_challenge;

import java.util.Arrays;

public class Candies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        if (num_people == 1) {
            res[0] = candies;
            return res;
        }
        int i = 0, count = 1, sum;
        while (candies > 0) {
            i = i % num_people;
            sum = Math.min(count, candies);
            res[i++] += sum;
            candies -= sum;
            ++count;
        }
        return res;
    }

    public static void main(String[] args) {
        Candies candies = new Candies();
        System.out.println(Arrays.toString(candies.distributeCandies(7, 4)));
        System.out.println(Arrays.toString(candies.distributeCandies(10, 3)));
        System.out.println(Arrays.toString(candies.distributeCandies(1000000000, 1)));
        System.out.println(Arrays.toString(candies.distributeCandies(1000000000, 3)));
    }
}
