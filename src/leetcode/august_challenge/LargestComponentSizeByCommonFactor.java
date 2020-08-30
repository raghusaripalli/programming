package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {
        Map<Integer,Integer> parent = new HashMap<>();

        for (int num : A)
            for (int fact = 2; fact*fact<=num; fact++)
                if (num % fact == 0){
                    union(num,fact,parent);
                    union(num,num/fact,parent);
                }

        int max = 1;
        Map<Integer,Integer> freq = new HashMap<>();
        for (Integer v : A) {
            int f = find(v,parent);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f)+1);
                max=Math.max(max,freq.get(f));
            }
            else freq.put(f,1);
        }
        return max;
    }

    public void union(int n, int m, Map<Integer,Integer> p) {
        int findN = find(n,p);
        int findM = find(m,p);
        if (findN < findM) p.put(findM,findN);
        else p.put(findN,findM);
    }

    public int find(Integer i, Map<Integer,Integer> parent) {
        parent.putIfAbsent(i, i);
        while (!i.equals(parent.get(i))) i = parent.get(i);
        return i;
    }

    public static void main(String[] args) {
        LargestComponentSizeByCommonFactor lc = new LargestComponentSizeByCommonFactor();
        System.out.println(lc.largestComponentSize(Helper.parseIntegerArray("[4,6,15,35]")));
        System.out.println(lc.largestComponentSize(Helper.parseIntegerArray("[20,50,9,63]")));
        System.out.println(lc.largestComponentSize(Helper.parseIntegerArray("[2,3,6,7,4,12,21,39]")));
    }
}
