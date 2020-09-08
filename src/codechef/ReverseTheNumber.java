package codechef;

import java.util.Scanner;

public class ReverseTheNumber {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        StringBuilder sb;
        while (total--!=0) {
            sb = new StringBuilder(sc.next());
            System.out.println(sb.reverse().toString().replaceAll("^0+", ""));
        }
    }
}
