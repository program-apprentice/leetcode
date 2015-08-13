package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 9:00 PM
 */
public class ReadNCharactersGivenRead4_157 {
    public int read4(char[] buf) {
        return 0;
    }
    public int read(char[] buf, int n) {
        if(n == 0) {
            return 0;
        }
        int bufIdx = 0;
        char[] tmpBuf = new char[4];
        int length4 = 0;
        do {
            length4 = read4(tmpBuf);
            for(int j = 0; j < length4 && bufIdx < n; j++) {
                buf[bufIdx] = tmpBuf[j];
                bufIdx++;
            }
        } while(bufIdx < n && length4 == 4);
        return bufIdx;
    }
}
