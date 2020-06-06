package codechef.dsa_learning_series.LRNDSA01;

import java.util.Scanner;

public class Lapindromes {
    private static void clear(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            s1[i] = 0;
            s2[i] = 0;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int size;
        String s;
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        boolean flag;
        while (total-- != 0) {
            flag = true;
            s = sc.next();
            size = s.length() / 2;
            clear(s1, s2);
            for (int i = 0; i < size; i++) {
                s1[s.charAt(i) - 'a']++;
            }
            if (s.length() % 2 != 0) size++;
            for (int i = size; i < s.length(); i++) {
                s2[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (s1[i] != s2[i]) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
