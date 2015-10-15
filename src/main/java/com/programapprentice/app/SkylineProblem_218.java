package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 10/14/15
 * Time: 1:43 PM
 */

// Solution is from http://wlcoding.blogspot.com/2015/05/the-skyline-problem.html?view=sidebar
public class SkylineProblem_218 {
    class Building {
        int left;
        int right;
        int height;
        public Building(int[] building) {
            this.left = building[0];
            this.right = building[1];
            this.height = building[2];
        }
    }

    class EdgePoint {
        int height;
        boolean isStart;
        public EdgePoint(int height, boolean isStart) {
            this.height = height;
            this.isStart = isStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        LinkedList<int[]> output = new LinkedList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return output;
        }

        // populate map and priority queue
        Map<Integer, List<EdgePoint>> edgePointMap = new HashMap<Integer, List<EdgePoint>>();
        PriorityQueue<Integer> xAxisPriorityQueue = new PriorityQueue<Integer>();

        for(int[] item : buildings) {
            Building building = new Building(item);
            List<EdgePoint> leftList = edgePointMap.get(building.left);
            if(leftList == null) {
                leftList = new ArrayList<EdgePoint>();
                xAxisPriorityQueue.add(building.left);
            }
            leftList.add(new EdgePoint(building.height, true));
            edgePointMap.put(building.left, leftList);

            List<EdgePoint> rightList = edgePointMap.get(building.right);
            if(rightList == null) {
                rightList = new ArrayList<EdgePoint>();
                xAxisPriorityQueue.add(building.right);
            }
            rightList.add(new EdgePoint(building.height, false));
            edgePointMap.put(building.right, rightList);
        }

        int x = 0;
        int preHeight = 0;
        int curHeight = 0;
        TreeMap<Integer, Integer> bstMap = new TreeMap<Integer, Integer>(); 
        while(!xAxisPriorityQueue.isEmpty()) {
            x = xAxisPriorityQueue.poll();
            List<EdgePoint> points = edgePointMap.get(x);
            for(EdgePoint point : points) {
                if(point.isStart) {
                    Integer value = bstMap.get(point.height);
                    if(value == null) {
                        value = 1;
                    } else {
                        value = value + 1;
                    }
                    bstMap.put(point.height, value);
                } else {
                    Integer value = bstMap.get(point.height);
                    if(value == 1) {
                        bstMap.remove(point.height);
                    } else {
                        bstMap.put(point.height, value-1);
                    }
                }
            }
            curHeight = bstMap.isEmpty() ? 0 : bstMap.lastKey();
            if(curHeight != preHeight) {
                output.add(new int[]{x, curHeight});
                preHeight = curHeight;
            }
        }

        return output;
    }
}

