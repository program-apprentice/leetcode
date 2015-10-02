package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 10/1/15
 * Time: 8:00 PM
 */
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) {
            return true;
        }
        HashMap<Integer, Set<Integer>> dependentsMap= new HashMap<Integer, Set<Integer>>();
        HashMap<Integer, Set<Integer>> preconditionsMap = new HashMap<Integer, Set<Integer>>();

        for(int i = 0; i < prerequisites.length; i++) {
            int[] item = prerequisites[i];
            Set<Integer> dependents = dependentsMap.get(item[1]);
            if(dependents == null) {
                dependents = new HashSet<Integer>();
            }
            dependents.add(item[0]);
            dependentsMap.put(item[1], dependents);

            Set<Integer> preconditions = preconditionsMap.get(item[1]);
            if(preconditions == null) {
                preconditions = new HashSet<Integer>();
            }
            preconditionsMap.put(item[1], preconditions);

            dependents = dependentsMap.get(item[0]);
            if(dependents == null) {
                dependents = new HashSet<Integer>();
            }
            dependentsMap.put(item[0], dependents);

            preconditions = preconditionsMap.get(item[0]);
            if(preconditions == null) {
                preconditions = new HashSet<Integer>();
            }
            preconditions.add(item[1]);
            preconditionsMap.put(item[0], preconditions);
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (Integer key : preconditionsMap.keySet()) {
            Set<Integer> preconditions = preconditionsMap.get(key);
            if(preconditions.isEmpty()) {
                queue.add(key);
            }
        }

        while(!queue.isEmpty()) {
            Integer key = queue.remove();
            for(Integer dependent : dependentsMap.get(key)) {
                Set<Integer> dependentPreconditions = preconditionsMap.get(dependent);
                if(dependentPreconditions != null) {
                    dependentPreconditions.remove(key);
                    if(dependentPreconditions.isEmpty()) {
                        queue.add(dependent);
                    }
                }
            }
            preconditionsMap.remove(key);
        }

        if(preconditionsMap.isEmpty()) {
            return true;
        }
        return false;
    }
}
