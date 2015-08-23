package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/23/15
 * Time: 1:09 PM
 */
public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n == 0) {
            list.add(0); // wrong: missing this one
            return list;
        }
        list.add(0);
        list.add(1);
        int shift = 1;
        for(int i = 2; i <= n; i++) {
            int size = list.size();
            shift = shift << 1;
            for(int j = size-1; j >= 0; j--) {
                Integer cur = list.get(j);
                list.add(cur + shift);
            }
        }
        return list;
    }
}
