package leetcode.august_challenge;

import java.util.Random;

public class ImplementRand10UsingRand7 {

    private static final Random random = new Random();

    private int rand7() {
        return random.nextInt(7) + 1;
    }

    private int rand10() {
        int a = rand7(), b = rand7();
        while (a > 5) a = rand7();
        while (b == 7) b = rand7();
        return b < 4 ? a : a + 5;
    }

    public static void main(String[] args) {
        ImplementRand10UsingRand7 ir = new ImplementRand10UsingRand7();
        for (int i = 0; i < 100; i++) {
            System.out.println(ir.rand10());
        }
    }
}
