package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 10:30 PM
 * Finished Time: 11:29 PM
 */

/**
 * If met 000, or 00, it can be 0
 * If met 001, or 01, it is not valid.
 * */
public class RestoreIPAddresses_93 {
    public List<List<String>> step(String s, int length) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(s.isEmpty()) {
            return output;
        }

        for(int i = 1; i <= 3 && i <= s.length(); i++) {
            String first = s.substring(0, i);
            if(!isValid(first)) {
                continue;
            }
            String nextString = s.substring(first.length());
            if(length == 1 && !nextString.isEmpty()) {
                continue;
            }
            if(length == 1) {
                List<String> item = new ArrayList<String>();
                item.add(first);
                output.add(item);
            } else {
                List<List<String>> tmp = step(nextString, length-1);
                if(!tmp.isEmpty()) {
                    for(List<String> e : tmp) {
                        e.add(0, first);
                        output.add(e);
                    }
                }
            }
        }
        return output;
    }

    public boolean isValid(String s) {
        int value = Integer.parseInt(s);
        if(value >255) {
            return false;
        }
        if(value != 0 && s.charAt(0) == '0') {
            return false;
        }
        if(value == 0 && s.length() > 1) { // missing this part.
            return false;
        }
        return true;
    }

    public String removeZero(String s) {
        int value = Integer.parseInt(s);
        return Integer.toString(value);
    }

    public String convertIP(List<String> ip) {
        StringBuilder sb = new StringBuilder();
        sb.append(ip.get(0));
        for(int i = 1; i < ip.size(); i++) {
            sb.append("." + removeZero(ip.get(i)));
        }
        return sb.toString();
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<String>();
        if(s == null || s.length() < 4) {
            return output;
        }

        List<List<String>> ips = step(s, 4);

        for(List<String> ip : ips) {
            output.add(convertIP(ip));
        }
        return output;
    }

}
