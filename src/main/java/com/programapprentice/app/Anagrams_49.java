package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 8/18/15
 * Time: 9:57 PM
 * finished Time: 10:20 PM
 */
public class Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String signature =  String.valueOf(cs);
            List<String> rec = map.get(signature);
            if(rec == null) {
                rec = new ArrayList<String>();
            }
            rec.add(s);
            map.put(signature, rec);
        }
        List<List<String>> output = new ArrayList<List<String>>();
        for(String key : map.keySet()) {
            List<String> e = map.get(key);
            Collections.sort(e);
            output.add(e);
        }
        return output;
    }
}
