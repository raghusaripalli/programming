package leetcode.arrays_and_strings;

public class Anagram {
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[256];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        for (char c : t.toCharArray()) {
            letters[c]--;
        }

        for (int i : letters) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("", ""));
        System.out.println(anagram.isAnagram("", "ikr"));
        System.out.println(anagram.isAnagram("ram", ""));
        System.out.println(anagram.isAnagram("rat", "car"));
        System.out.println(anagram.isAnagram("act", "cat"));
        System.out.println(anagram.isAnagram("anagram", "anagram"));
    }
}
