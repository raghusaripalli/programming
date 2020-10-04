package leetcode.contest_209;

import java.util.TreeMap;

public class SpecialArray {
    public int specialArray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < 1001; i++) {
            int count = map.getOrDefault(i, 0);
            int ckey = i+1;
            while (map.ceilingKey(ckey) != null) {
                ckey = map.ceilingKey(ckey);
                count += map.getOrDefault(ckey, 0);
                ckey++;
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }
}
