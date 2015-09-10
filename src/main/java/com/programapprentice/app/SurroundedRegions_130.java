package com.programapprentice.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 9/9/15
 * Time: 6:07 PM
 */
public class SurroundedRegions_130 {
    class Point {
        public int row;
        public int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void updateList(int row, int col, Queue<Point> queue, List<Point> list,
                           boolean[][] scanStatus, char[][] board) {
        if(!scanStatus[row][col] && board[row][col] == 'O') {
            queue.add(new Point(row, col));
            list.add(new Point(row, col));
            scanStatus[row][col] = true;
        }
    }

    public void checkStatus(Queue<Point> queue, List<Point> list, Point cur,
                            boolean[][] scanStatus, char[][] board,
                            int numRows, int numCols) {
        queue.add(cur);
        list.add(cur); // missing this one.
        int row = 0;
        int col = 0;
        boolean isChanged = true;
        while(!queue.isEmpty()) {
            cur = queue.remove(); // wrong: Point point = queue.remove();
            if(cur.row == 0 || cur.row == numRows - 1 // wrong: if(point.row == 0 || point.row == numCols- 1
                    || cur.col == 0 || cur.col == numCols-1) {
                isChanged = false;
            }
            // up
            if(cur.row > 0) {
                row = cur.row - 1;
                col = cur.col;
                updateList(row, col, queue, list, scanStatus, board);
            }
            // down
            if(cur.row < numRows-1 ) {
                row = cur.row + 1;
                col = cur.col;
                updateList(row, col, queue, list, scanStatus, board);
            }
            // left
            if(cur.col > 0 ) {
                row = cur.row;
                col = cur.col - 1;
                updateList(row, col, queue, list, scanStatus, board);
            }
            // right
            if(cur.col < numCols-1) {
                row = cur.row;
                col = cur.col + 1; // wrong: col = cur.col - 1;
                updateList(row, col, queue, list, scanStatus, board);
            }
        }
        if(isChanged) {
            for(Point point : list) {
                board[point.row][point.col] = 'X';
            }
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length <= 1) {
            return;
        }
        int numRows = board.length;
        int numCols = board[0].length;
        boolean[][] scanStatus = new boolean[numRows][numCols];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(scanStatus[i][j]) {
                    continue;
                }
                if(board[i][j] == 'O') {
                    Queue<Point> queue = new LinkedList<Point>();
                    List<Point> connected = new ArrayList<Point>();
                    Point point = new Point(i,j);
                    scanStatus[i][j] = true; // missing this one
                    checkStatus(queue, connected, point, scanStatus, board, numRows, numCols);
                }
            }
        }
    }
}
