package leetcode.july_challenge;

import leetcode.Helper;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n2) - count.get(n1));
        heap.addAll(count.keySet());
        int[] res = new int[k];
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = Helper.parseIntegerArray("[1,1,1,2,2,3]");
        int k = 2;
        TopKFrequent frequent = new TopKFrequent();
        int[] res = frequent.topKFrequent(input, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
