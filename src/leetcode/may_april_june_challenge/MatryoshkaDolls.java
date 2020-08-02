package leetcode.may_april_june_challenge;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MatryoshkaDolls {
    public int maxMatryoshkas(int n, int[] sizes) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int diff, min_value, count = 0;
        Map.Entry<Integer, Integer> entry;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sizes[i]))
                map.put(sizes[i], map.get(sizes[i]) + 1);
            else
                map.put(sizes[i], 1);

            if (map.size() == 3) {
                min_value = map.values().stream().min(Comparator.comparingInt(o -> o)).get();
                count += min_value;
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    entry = iterator.next();
                    diff = entry.getValue() - min_value;
                    if (diff == 0)
                        iterator.remove();
                    else
                        map.put(entry.getKey(), diff);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MatryoshkaDolls matryoshkaDolls = new MatryoshkaDolls();
        // Test Case - [1,2,3,4,5,6,7]
        int[] sizes = new int[7];
        for (int i = 0; i < 7; i++) {
            sizes[i] = (7 - i) % 3;
        }
        int res = matryoshkaDolls.maxMatryoshkas(7, sizes);
        System.out.println(res);
    }
}
