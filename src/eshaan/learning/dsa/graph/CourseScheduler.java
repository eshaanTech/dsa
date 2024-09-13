package eshaan.learning.dsa.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
[[1,0],[0,1]]
 */
public class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(prerequisites[0][0]);
        visited.add(prerequisites[0][0]);
        while(!stack.isEmpty()){

        }
        return false;
    }


}
