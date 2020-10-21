package leetcode.october;

import leetcode.may_april_june_challenge.Helper;

import java.util.Arrays;
import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || ans.isEmpty() || ans.getLast() < 0)
                ans.add(asteroids[i]);
            else if (ans.getLast() <= -asteroids[i]) {
                if (ans.getLast() < -asteroids[i])
                    i--;
                ans.removeLast();
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        System.out.println(Arrays.toString(ac.asteroidCollision(Helper.parseIntegerArray("[8,-8]"))));
    }
}
