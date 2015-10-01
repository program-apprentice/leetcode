package com.programapprentice.app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: ruijiang
 * Date: 9/30/15
 * Time: 9:54 PM
 */
public class NumberOfIslands_200 {
    private class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int output = 0;
        int height = grid.length;
        int width = grid[0].length;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(grid[i][j] == '1') {
                    Queue<Point> queue = new LinkedList<Point>();
                    queue.add(new Point(i, j));
                    grid[i][j] = '2';
                    while(!queue.isEmpty()) {
                        Point point = queue.remove();
                        if(point.row > 0 && grid[point.row-1][point.col] == '1') {
                            queue.add(new Point(point.row-1, point.col));
                            grid[point.row-1][point.col] = '2';
                        }
                        if(point.row < height-1 && grid[point.row+1][point.col] == '1') {
                            queue.add(new Point(point.row+1, point.col));
                            grid[point.row+1][point.col] = '2';
                        }
                        if(point.col > 0 && grid[point.row][point.col-1] == '1') {
                            queue.add(new Point(point.row, point.col-1));
                            grid[point.row][point.col-1] = '2';
                        }
                        if(point.col < width-1 && grid[point.row][point.col+1] == '1') {
                            queue.add(new Point(point.row, point.col+1));
                            grid[point.row][point.col+1] = '2';
                        }
                    }
                    output++;
                }
            }
        }
        return output;
    }
}
