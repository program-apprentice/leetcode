package com.programapprentice.util;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 1:43 PM
 */
public class Util {
    public static void printListString(List<String> list) {
        for(String s : list) {
            System.out.println(s);
        }
    }

    public static void printListInteger(List<Integer> list) {
        for(Integer s : list) {
            System.out.print(s + " ");
        }
    }

    public static void printListOfListNumbers(List<List<Integer>> input) {
        for(List<Integer> item: input) {
            for(Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    // assume the length for each item in input are the same
    public static char[][] convertStringsToCharArray(String[] input) {
        int row = input.length;
        int col = input[0].length();
        char[][] output = new char[row][col];
        for(int i = 0; i < row; i++) {
            output[i] = input[i].toCharArray();
        }
        return output;
    }
}
