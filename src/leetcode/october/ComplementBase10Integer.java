package leetcode.october;

public class ComplementBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0)
            return 1;
        int res = 0, pow = 1;
        while (N > 0) {
            if ((N & 1) == 0) {
                res += pow;
            }
            N >>= 1;
            pow *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        ComplementBase10Integer cb = new ComplementBase10Integer();
        for (int i = 0; i < 32; i++) {
            System.out.println(cb.bitwiseComplement(i));
        }
    }

}
