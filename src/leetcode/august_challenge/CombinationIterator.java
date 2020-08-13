package leetcode.august_challenge;

import java.util.ArrayList;
import java.util.List;

class CombinationIterator {

    private final List<String> combinations = new ArrayList<>();
    private final int combinationLength;
    private int index = 0;

    public CombinationIterator(String characters, int combinationLength) {
        this.combinationLength = combinationLength;
        generate(characters, new StringBuilder(), 0);
    }

    private void generate(String characters, StringBuilder sb, int index) {
        if (sb.length() == combinationLength) {
            combinations.add(sb.toString());
        } else {
            for (int i = index; i < characters.length(); i++) {
                sb.append(characters.charAt(i));
                generate(characters, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String next() {
        return combinations.get(index++);
    }

    public boolean hasNext() {
        return index < combinations.size();
    }

    public static void main(String[] args) {
        String input = "abcde";
        for (int i = 0; i <= input.length(); i++) {
            printIterator(new CombinationIterator(input, i));
        }
    }

    private static void printIterator(CombinationIterator it) {
        String space = " ";
        while (it.hasNext()) {
            System.out.print(it.next() + space);
        }
        System.out.println();
    }
}
