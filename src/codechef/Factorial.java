package codechef;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int count;
        while (total-- != 0) {
            count = 0;
            int num = sc.nextInt();
            for (int i = 5; num / i >= 1; i *= 5)
                count += (num / i);
            System.out.println(count);
        }
    }
}
