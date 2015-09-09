package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/8/15
 * Time: 10:01 PM
 */
public class Triangle_120 {
    public int min(List<Integer> data) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < data.size(); i++) {
            min = min < data.get(i) ? min : data.get(i);
        }
        return min;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) {
            return 0;
        }
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> tmp = null;
        List<Integer> cur = triangle.get(0);
        result.add(cur.get(0));
        for(int i = 1; i < triangle.size(); i++) {
            cur = triangle.get(i);
            tmp = new ArrayList<Integer>();
            for(int j = 0; j < cur.size(); j++) {
                if(j == 0) {
                    tmp.add(cur.get(j) + result.get(j));
                } else if (j == cur.size()-1) {
                    tmp.add(cur.get(j) + result.get(j-1));
                } else {
                    tmp.add(cur.get(j) + Math.min(result.get(j-1), result.get(j)));
                }
            }
            result = tmp;
        }
        return min(result);
    }
}
