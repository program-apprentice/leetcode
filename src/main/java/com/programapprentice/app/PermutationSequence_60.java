package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/22/15
 * Time: 9:58 PM
 */
public class PermutationSequence_60 {
    public int[] fab(int n) {
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 2; i <= n; i++) {
            result[i-1] = result[i-2] * i;
        }
        return result;
    }

    // find next space where rec[idx] == false
    public int incremental(boolean[] rec, int n, int start) {
        for(int i = start+1; i < n; i++) {
            if(!rec[i]) {
                return i;
            }
        }
        return -1;
    }

    public String permutation(boolean[] rec, int n, int k, int[] f, int left) {
        StringBuffer sb = new StringBuffer();
        if(k == 0) {
            for(int i = n-1; i >= 0; i--) { // wrong: for(int i = n-1; i >= 0; i++) {
                if(!rec[i]) {
                    rec[i] = true;
                    sb.append(i+1);
                }
            }
            return sb.toString();
        }
        if(k == 1) {
            for(int i = 0; i < n; i++) {
                if(!rec[i]) {
                    rec[i] = true;
                    sb.append(i+1);
                }
            }
            return sb.toString();
        }
        if(k < f[left-2]) { // wrong: if(k < f[left-1]) {
            int available = incremental(rec, n, -1);
            rec[available] = true;
            sb.append(available+1);
            sb.append(permutation(rec, n, k, f, left-1));
        } else if (k % f[left-2] != 0){ // wrong: } else if (k > f[left-1]){
            int available = incremental(rec, n, -1);
            int step = k / f[left-2]; // wrong: int step = k / f[left-1];
            int start = 0;
            while(start < step) {
                start++;
                available = incremental(rec, n, available);
            }
            rec[available] = true;
            sb.append(available+1);
            // wrong: sb.append(permutation(rec, n, k % f[left-1], f, left-1));
            sb.append(permutation(rec, n, k - f[left-2] * step, f, left-1));

        } else {
            int step = k / f[left-2]; // wrong: int step = k / f[left-1];
            int start = 1;
            int available = incremental(rec, n, -1);
            while(start < step) {
                start++;
                available = incremental(rec, n, available);
            }
            rec[available] = true;
            sb.append(available+1);
            sb.append(permutation(rec, n, 0, f, left-1));
        }
        return sb.toString();
    }

    public String getPermutation(int n, int k) {
        if(n == 1) {
            return "1";
        }
        int[] f = fab(n);
        k = k % f[n-1];
        boolean[] rec = new boolean[n];
        return permutation(rec, n, k, f, n);
    }
}
