package com.programapprentice.app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 9:12 PM
 */
public class FractionToRecurringDecimal_166 {
    public String convertList2String(List<Integer> list, int last, boolean isEndless) {
        StringBuilder sb = new StringBuilder();
        if(!isEndless) {
            for(Integer ele : list) {
                sb.append(ele.toString());
            }
        } else {
            int i = 0;
            for(i = 0; i <= last; i++) {
                sb.append(list.get(i).toString());
            }
            sb.append('(');
            for(; i < list.size(); i++) {
                sb.append(list.get(i).toString());
            }
            sb.append(')');
        }

        return sb.toString();
    }

    public String  getFraction(long numerator, long denominator) {
        if(numerator == 0) {
            return "";
        }
        List<Integer> integerResult = new ArrayList<Integer>();
        Map<Long, Integer> record = new HashMap<Long, Integer>();
        while(numerator != 0) {
            record.put(numerator, integerResult.size());
            long tmp = numerator * 10 / denominator;
            integerResult.add((int)tmp);
            numerator = (numerator * 10) % denominator;
            if(null != record.get(numerator)) {
                return convertList2String(integerResult, record.get(numerator)-1, true);
            }
        }
        return convertList2String(integerResult, 0, false);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) {
            return "";
        }
        boolean isNegative = (numerator < 0 && denominator > 0)
                || (numerator > 0 && denominator < 0);
        long longNumerator = Math.abs((long)numerator);
        long longDenominator = Math.abs((long)denominator);
        // 1. get integer part
        long integerPart = longNumerator / longDenominator;
        longNumerator = longNumerator % longDenominator;

        StringBuilder sb = new StringBuilder();
        if(isNegative) {
            sb.append("-");
        }
        if(integerPart == 0 ) {
            sb.append("0");
        } else {
            sb.append(Long.toString(integerPart));
        }
        // 2. get fraction part
        String fraction = getFraction(longNumerator, longDenominator);
        if(fraction.isEmpty()) {
            return sb.toString();
        }
        sb.append(".");
        sb.append(fraction);
        return sb.toString();
    }
}
