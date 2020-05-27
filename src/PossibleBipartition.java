// Problem Statement: https://leetcode.com/problems/possible-bipartition/
// Graph - DFS - Bipartate

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean[][] g = new boolean[N][N];
        for (int[] d : dislikes) {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++)
            if (colors[i] == 0 && !paint(i, 1, colors, g))
                return false;
        return true;
    }

    boolean paint(int u, int color, int[] colors, boolean[][] g) {
        if (colors[u] != 0)
            return colors[u] == color;
        colors[u] = color;
        for (int v = 0; v < colors.length; v++)
            if (g[u][v] && !paint(v, -color, colors, g))
                return false;
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition pb = new PossibleBipartition();
        int[][] dislikes = new int[3][2];
        for (int i = 0; i < 3; i++) {
            dislikes[i] = new int[2];
        }
        dislikes[0][0] = 1;
        dislikes[0][1] = 2;
        dislikes[1][0] = 1;
        dislikes[1][1] = 3;
        dislikes[2][0] = 2;
        dislikes[2][1] = 4;
        boolean res = pb.possibleBipartition(4, dislikes);
        System.out.println(res);

        /*
            test cases:

           10
           [[4,7],[4,8],[2,8],[8,9],[1,6],[5,8],[1,2],[6,7],[3,10],[8,10],[1,5],[7,10],[1,10],[3,5],[3,6],[1,4],[3,9],[2,3],[1,9],[7,9],[2,7],[6,8],[5,7],[3,4]]

           10
           [[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8],[1,2],[4,9],[6,10],[8,10],[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]

         */
    }
}
