package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/11/15
 * Time: 9:28 PM
 */
/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return output;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        output.add(tmp);
        List<Integer> pre = null;
        for(int i = 1; i < numRows; i++) {
            pre = output.get(i-1);
            tmp = new ArrayList<Integer>();
            tmp.add(1);
            if(pre.size() == 1) {
                tmp.add(pre.get(0));
            } else {
                for (int j = 0; j < pre.size() - 1; j++) {
                    tmp.add(pre.get(j) + pre.get(j + 1));
                }
                tmp.add(1);
            }
            output.add(tmp);
        }
        return output;
    }
}
