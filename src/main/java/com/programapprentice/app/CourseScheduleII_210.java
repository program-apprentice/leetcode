package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 10/1/15
 * Time: 9:59 PM
 */
public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) {
            return new int[0];
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
        List<Integer> order = new ArrayList<Integer>();
        Set<Integer> record = new HashSet<Integer>();
        for (Integer key : preconditionsMap.keySet()) {
            Set<Integer> preconditions = preconditionsMap.get(key);
            if(preconditions.isEmpty()) {
                queue.add(key);
                order.add(key);
                record.add(key);
            }
        }
        for(Integer key : record) {
            preconditionsMap.remove(key);
        }

        while(!queue.isEmpty()) {
            Integer key = queue.remove();
            for(Integer dependent : dependentsMap.get(key)) {
                Set<Integer> dependentPreconditions = preconditionsMap.get(dependent);
                if(dependentPreconditions != null) {
                    dependentPreconditions.remove(key);
                    if(dependentPreconditions.isEmpty()) {
                        queue.add(dependent);
                        order.add(dependent);
                        record.add(dependent);
                    }
                }
            }
            preconditionsMap.remove(key);
        }

        if(!preconditionsMap.isEmpty()) {
            return new int[0];
        }
        if(record.size() != numCourses) {
            for(int i = 0; i < numCourses; i++) {
                if(!record.contains(i)) {
                    order.add(i);
                }
            }
        }
        int[] output = new int[order.size()];
        for(int i = 0; i < output.length; i++) {
            output[i] = order.get(i);
        }
        return output;
    }
}
