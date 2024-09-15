package eshaan.learning.dsa.graph;

import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
[[1,0],[0,1]]
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize the graph with empty lists for each course
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill the graph and the in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);  // Add an edge from prereq to course
            inDegree[course]++;             // Increase the in-degree of the course
        }

        // Step 2: Initialize the queue with all courses that have 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the queue
        int processedCourses = 0; // Keep track of the number of processed courses

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            processedCourses++;

            // For each neighbor (course that depends on currentCourse)
            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;  // Reduce the in-degree
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);  // Add to the queue if no more prerequisites
                }
            }
        }

        // Step 4: Check if all courses have been processed
        return processedCourses == numCourses;
    }


}
