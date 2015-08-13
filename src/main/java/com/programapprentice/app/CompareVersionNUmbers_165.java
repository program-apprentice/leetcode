package com.programapprentice.app;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 10:13 PM
 */
public class CompareVersionNumbers_165 {
    public List<Integer> parse(String version) {
        List<Integer> output = new ArrayList<Integer>();
        String[] ss = version.split("\\.");
        for(String s : ss) {
            output.add(Integer.parseInt(s));
        }
        return output;
    }

    public int compareVersion(String version1, String version2) {
        List<Integer> list1 = parse(version1);
        List<Integer> list2 = parse(version2);
        int num = Math.min(list1.size(), list2.size());

        for(int i = 0; i < num; i++) {
            if(list1.get(i) < list2.get(i)) {
                return -1;
            } else if (list1.get(i) > list2.get(i)) {
                return 1;
            }
        }
        if(list1.size() > num) {
            for(int i = num; i < list1.size(); i++ ) {
                if(list1.get(i) != 0) {
                    return 1;
                }
            }
        } else if (list2.size() > num){
            for(int i = num; i < list2.size(); i++ ) {
                if(list2.get(i) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
