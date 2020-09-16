package graphs;

import java.util.*;

public class Traversals {
    private int[] bfs(List<List<Integer>> adjacencyList) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size()];
        int[] prev = new int[adjacencyList.size()];
        Arrays.fill(prev, -1);
        visited[0] = true;
        prev[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> neighbours = adjacencyList.get(node);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    prev[neighbour] = node;
                }
            }
        }
        return prev;
    }

    private boolean findPath(int startNode, int endNode, int[] prev) {
        int i = endNode;
        System.out.print(i + " ");
        while (i > 0) {
            i = prev[i];
            System.out.print(i + " ");
        }
        System.out.println();
        return i == startNode;
    }

    public static void main(String[] args) {
        Traversals graphTraversals = new Traversals();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2));
        input.add(Arrays.asList(0, 2, 3, 4));
        input.add(Arrays.asList(0, 1, 3));
        input.add(Arrays.asList(1, 2, 4));
        input.add(Arrays.asList(1, 3));
        int[] output = graphTraversals.bfs(input);
        System.out.println(graphTraversals.findPath(0, 4, output));
    }
}
