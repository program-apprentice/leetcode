package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 10:51 PM
 */
public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int n) {
        List<Character> list = new ArrayList<Character>();
        int tmp = n;
        int mod = 0;
        while(tmp != 0) {
            mod = tmp % 26;
            tmp = tmp / 26;
            if(mod == 0) {
                list.add(0, 'Z');
                tmp--;
            } else {
                list.add(0, (char)(mod + 'A' - 1));
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
