package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 10/19/15
 * Time: 11:07 AM
 */
public class Dungeon_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int h = dungeon.length;
        int w = dungeon[0].length;

        int[][] record = new int[h][w];
        for(int i = h-1; i >= 0; i--) {
            for(int j = w-1; j >= 0; j--) {
                if(i == h-1 && j == w-1) {
                    record[i][j] = Math.max(1, 1-dungeon[i][j]);
                } else if(i == h-1) {
                    record[i][j] = Math.max(1, Math.max(1, record[i][j+1] - dungeon[i][j]));
                } else if (j == w-1) {
                    record[i][j] = Math.max(1, Math.max(1, record[i+1][j]-dungeon[i][j]));
                } else {
                    record[i][j] = Math.max(1,
                            Math.max(1, Math.min(record[i][j+1], record[i+1][j])-dungeon[i][j]));
                }
            }
        }
        return record[0][0];
    }
}

/**
 * 2 1
 * 1 -1
 * */

/**
 * -2 -3  3
 * -5 -10 1
 * 1  3  -5
 * */

/**
 * -2 -3  3
 * -5 -10 1
 * 1  -3 -5
 * */