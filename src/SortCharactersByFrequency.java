import java.util.HashMap;
import java.util.PriorityQueue;

// Problem Statement: https://leetcode.com/problems/sort-characters-by-frequency/

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.remove();
            for (int i = 0; i < map.get(c); i++) {
                ans.append(c);
            }
            // In Java 11 + the above loop can be replaced with below code
            // ans.append(String.valueOf(c).repeat(map.get(c)));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency charactersByFrequency = new SortCharactersByFrequency();
        // Test Cases
        System.out.println(charactersByFrequency.frequencySort("tree")); // eetr or eert
        System.out.println(charactersByFrequency.frequencySort("cccaaa")); // cccaaa or aaaccc
        System.out.println(charactersByFrequency.frequencySort("Aabb")); // bbAa or bbaA
    }
}
