package com.programapprentice.app;

import java.util.HashMap;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 10:08 PM
 * Finished Time: 10:15 PM
 */
public class TwoSumIII_170 {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        int val = 1;
        if(map.containsKey(number)) {
            val += map.get(number);
        }
        map.put(number, val);
    }

    public boolean find(int value) {
        for(Integer key : map.keySet()) {
            if(value-key == key) {
                if(map.get(value-key) >= 2) {
                    return true;
                }
            } else {
                if (map.containsKey(value - key)) {
                    return true;
                }
            }
        }
        return false;
    }
}
