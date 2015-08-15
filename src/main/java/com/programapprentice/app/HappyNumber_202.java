package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 11:12 PM
 */
public class HappyNumber_202 {
    public List<Integer> convert(int n) {
        List<Integer> output = new ArrayList<Integer>();
        int tmp = 0;
        while (n != 0) {
            tmp = n % 10;
            if (tmp != 0) {
                output.add(tmp);
            }
            n = n / 10;
        }
        return output;
    }

    public int sumSquare(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i * i;
        }
        return sum;
    }

    public String convert2Str(List<Integer> list) {
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (Integer i : list) {
            sb.append(i + '0');
        }
        return sb.toString();
    }

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        Set<String> set = new HashSet<String>();

        List<Integer> nums = null;
        int sum = 0;
        String str = null;
        nums = convert(n);
        str = convert2Str(nums);
        while(!set.contains(str)) {
            set.add(str);
            sum = sumSquare(nums);
            if(sum == 1) {
                return true;
            }
            nums = convert(sum);
            str = convert2Str(nums);
        };
        return false;
    }
}
