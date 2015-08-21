package com.programapprentice.app;

import java.util.LinkedList;

/**
 * User: program-apprentice
 * Date: 8/20/15
 * Time: 6:18 PM
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<String>();
        String[] segments = path.split("/");
        for(String s : segments) {
            if(s.equals(".") || s.isEmpty()) {
                continue;
            } else if (s.equals("..")) {
                if(!list.isEmpty()) {
                    list.removeLast();
                }
            } else {
                list.offerLast(s);
            }
        }
        if(list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append("/" + s);
        }
        return sb.toString();
    }
}
