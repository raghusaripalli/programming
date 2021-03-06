package leetcode.may_april_june_challenge;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static int[] parseIntegerArray(String input) {
        String[] strings = input.split(",");
        List<Integer> arr = new ArrayList<>();
        for (String string : strings) {
            string = string.trim();
            int x = 0;
            for (int i = 0; i < string.length(); i++) {
                try {
                    x = x * 10 + Integer.parseInt(string.charAt(i) + "");
                } catch (NumberFormatException ignored) {
                }
            }
            arr.add(x);
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static void prettyPrint(List<Integer> list) {
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void prettyPrint(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
