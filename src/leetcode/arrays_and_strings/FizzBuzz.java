package leetcode.arrays_and_strings;

import java.util.Collections;
import java.util.List;

public class FizzBuzz {
    private List<String> fizzBuzz(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        return new java.util.AbstractList<String>() {
            private static final String f = "Fizz";
            private static final String b = "Buzz";
            private static final String fb = "FizzBuzz";

            public String get(int i) {
                i++;
                if (i % 15 == 0)
                    return fb;
                if (i % 3 == 0)
                    return f;
                if (i % 5 == 0)
                    return b;
                return String.valueOf(i);
            }

            public int size() {
                return n;
            }
        };
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        List<String> res = fb.fizzBuzz(15);
        for (String s : res) {
            System.out.print(s + ",");
        }
        System.out.println();
        res = fb.fizzBuzz(25);
        for (String s : res) {
            System.out.print(s + ",");
        }
        System.out.println();
    }
}
