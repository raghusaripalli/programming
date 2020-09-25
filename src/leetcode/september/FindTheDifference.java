package leetcode.september;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int i = -1, sum = 0;
        while ((++i) < s.length()) {
            sum ^= t.charAt(i) ^ s.charAt(i);
        }
        sum ^= t.charAt(i);
        return (char) sum;
    }

    public static void main(String[] args) {
        FindTheDifference ftd = new FindTheDifference();
        System.out.println(ftd.findTheDifference("abc", "bcac"));
    }
}
