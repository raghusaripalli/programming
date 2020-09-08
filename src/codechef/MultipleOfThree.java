package codechef;

import java.util.Scanner;

public class MultipleOfThree {
    private static int sumOfDigits(int a) {
        int units = a % 10;
        int tens = a / 10;
        return units + tens;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        long k;
        int a, b, sum;
        while (total-- != 0) {
            k = sc.nextLong();
            a = sc.nextInt();
            b = sc.nextInt();
            sum = sumOfDigits(a + b);
            System.out.println(sum % 3 == 0 ? "YES" : "NO");
        }
    }
}
