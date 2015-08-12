package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/11/15
 * Time: 9:41 PM
 */
public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> output = new ArrayList<Integer>();
        output.add(1);
        if(rowIndex == 0) {
            return output;
        }
        output.add(1);
        if (rowIndex == 1) {
            return output;
        }
        for(int i = 2; i <= rowIndex; i++) {
            output.add(0, 1);
            for(int j = 1; j < output.size()-1; j++) {
                output.set(j, output.get(j) + output.get(j+1));
            }
        }
        return output;
    }
}
