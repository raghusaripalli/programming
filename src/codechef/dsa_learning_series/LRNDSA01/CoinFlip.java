package codechef.dsa_learning_series.LRNDSA01;

import java.util.Scanner;

public class CoinFlip {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int games, i, n, q;
        while (total-- != 0) {
            games = sc.nextInt();
            while (games-- != 0) {
                i = sc.nextInt();
                n = sc.nextInt();
                q = sc.nextInt();
                if (n % 2 == 0) {
                    System.out.println(n / 2);
                } else {
                    if (i != q)
                        System.out.println((n / 2) + 1);
                    else
                        System.out.println(n / 2);
                }
            }
        }
    }
}
