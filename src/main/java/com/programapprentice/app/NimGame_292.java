package com.programapprentice.app;

public class NimGame_292 {
    public boolean canWinNim_tooslow(int n) {
        if(n <= 3) {
            return true;
        }
        boolean first = true;
        boolean second = true;
        boolean third = true;
        boolean result = false;
        for(int i = 4; i <= n; i++ ) {
            result = !(first && second && third);
            first = second;
            second = third;
            third = result;
        }
        return result;
    }


    public boolean canWinNim(int n) {
        if(n%4 == 0) {
            return false;
        }
        return true;
    }

}