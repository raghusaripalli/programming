package leetcode.may_april_june_challenge;

import java.util.*;

// Problem Statement: https://leetcode.com/problems/course-schedule/
// DFS, Graph, Topological Sort

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] outDegree = new int[numCourses]; // outDegree[i] = # of prerequisites for course i
        Map<Integer, List<Integer>> dependants = new HashMap<>(); // Courses that depend on the key
        Queue<Integer> completed = new LinkedList<>(); // Used to find dependants and decrease their outDegree
        for (int[] pair : prerequisites) {
            outDegree[pair[0]]++;
            dependants.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        int coursesCompleted = 0;
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                completed.add(i);
            }
        }
        while (!completed.isEmpty()) {
            int course = completed.poll();
            if (++coursesCompleted >= numCourses) return true;
            if (!dependants.containsKey(course)) continue;
            for (int dependent : dependants.get(course)) {
                if (--outDegree[dependent] == 0) {
                    completed.add(dependent);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        // Test Case 2, [[1,0]] - true
        int[][] prerequisites = new int[1][2];
        prerequisites[0] = new int[2];
        prerequisites[0][0] = 1;
        boolean res = courseSchedule.canFinish(2, prerequisites);
        System.out.println(res);
    }
}
