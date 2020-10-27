package leetcode.october;

import java.util.Scanner;

public class WaitingLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int age;
        int queue1 = 0, queue2 = 0;
        boolean validInput = true;
        for (int i = 0; i < n; i++) {
            age = scanner.nextInt();
            if (age < 10 || age > 100) {
                validInput = false;
                break;
            }
            if (age > 60) {
                if (queue2 < 5)
                    queue2++;
                else
                    queue1++;
            } else {
                queue1++;
            }
        }

        if (validInput) {
            System.out.printf("QUEUE1 TIME:%d mins\n", queue1 * 15);
            System.out.printf("QUEUE2 TIME:%d mins\n", queue2 * 15);
        } else {
            System.out.println("INVALID INPUT");
        }
    }
}
