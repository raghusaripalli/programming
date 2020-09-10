package leetcode.september;

public class BullsAndCows {
    private String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        System.out.println(bc.getHint("1807", "7810"));
        System.out.println(bc.getHint("1123", "0111"));
        System.out.println(bc.getHint("4271", "1234"));
        System.out.println(bc.getHint("1111", "1101"));
    }
}
