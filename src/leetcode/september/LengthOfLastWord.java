package leetcode.september;

public class LengthOfLastWord {
    private int lengthOfLastWord(String s) {
        int i = s.length() - 1, len = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLastWord llw = new LengthOfLastWord();
        System.out.println(llw.lengthOfLastWord(""));
        System.out.println(llw.lengthOfLastWord(" "));
        System.out.println(llw.lengthOfLastWord("Hello"));
        System.out.println(llw.lengthOfLastWord(" Hello "));
        System.out.println(llw.lengthOfLastWord("Hello World"));
        System.out.println(llw.lengthOfLastWord("Hello World  "));
    }
}
