package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long) nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(Helper.parseIntegerArray("[1,5,9,1,5,9]"), 2, 3));
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(Helper.parseIntegerArray("[1,2,3,1]"), 3, 0));
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(Helper.parseIntegerArray("[1,0,1,1]"), 1, 2));
    }
}
