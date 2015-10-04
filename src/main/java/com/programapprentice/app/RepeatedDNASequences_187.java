package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 10/1/15
 * Time: 9:33 PM
 */
public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequencesTwoSlow(String s) {
        if(s == null || s.length() < 10) {
            return null;
        }
        Set<String> result = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int end = s.length() - 10 + 1;
        for(int i = 0; i < end; i++) {
            String str = s.substring(i, i + 10);
            if(map.get(str) == null) {
                map.put(str, i);
            } else {
                result.add(str);
            }
        }
        return new ArrayList<String>(result);
    }

    // the length of s should be 10
    public int convertStr2Int(int[] charConvert, String s) {
        int output = 0;
        for(int i = 0; i < s.length(); i++) {
            output = output << 2;
            output = output | charConvert[s.charAt(i) - 'A'];
        }
        return output;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) {
            return new ArrayList<String>();
        }
        int[] charConvert = new int[26];
        charConvert['A'-'A'] = 0;
        charConvert['C'-'A'] = 1;
        charConvert['G'-'A'] = 2;
        charConvert['T'-'A'] = 3;
        Set<String> result = new HashSet<String>();
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        Integer convertedInt = convertStr2Int(charConvert, s.substring(0, 10));
        map.put(convertedInt, true);
        int mask = 0XFFFFF;
        for(int i = 10; i < s.length(); i++) {
            convertedInt = (convertedInt << 2) & mask;
            convertedInt = convertedInt | charConvert[s.charAt(i) - 'A'];
            if(map.get(convertedInt) == null) {
                map.put(convertedInt, true);
            } else {
                result.add(s.substring(i-9, i+1)); // wrong: result.add(s.substring(i-10, i));
            }
        }
        return new ArrayList<String>(result);
    }
}
