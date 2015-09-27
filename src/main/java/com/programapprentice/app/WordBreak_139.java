package com.programapprentice.app;

import java.util.Set;

public class WordBreak_139 {
    public boolean wordBreakTooSlow(String s, Set<String> wordDict) {
        for(int i = 0; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0, i+1))) {
                if(wordBreakTooSlow(s.substring(i + 1), wordDict)) {
                   return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] record = new boolean[s.length()+1];
        record[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= i; j++) {
                if(record[j-1] && wordDict.contains(s.substring(j-1, i))) {
                    record[i] = true;
                }
            }
        }
        return record[s.length()];
    }
}
