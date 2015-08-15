package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 12:16 AM
 */
// Count the number of prime numbers less than a non-negative number, n.
public class CountPrimes_204 {
    public boolean isPrime(int n) {
        if(n == 2) {
            return true;
        }
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // This one is not fast enough
    public int countPrimes_tradition(int n) {
        int counter = 0;
        for(int i = 1; i <= n; i++) {
            if(isPrime(i)) {
                counter ++;
            }
        }
        return counter;
    }

    public int countPrimes_v2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        boolean[] isNotPrime = new boolean[n];

        isNotPrime[0] = false; // 1
        isNotPrime[1] = false; // 2
        int tmp = 0;
        for(int i = 2; i <= n; i++) {
            if(isNotPrime[i-1]) {
                // i is not prime
                continue;
            }
            if(isPrime(i)) {
                tmp = 2 * i;
                while(tmp <= n) {
                    isNotPrime[tmp - 1] = true;
                    tmp += i;
                }
            }

        }
        int counter = 0;
        for(int i = 0; i < n; i++) {
            counter += !isNotPrime[i] ? 1 : 0;
        }
        return counter;
    }

    //https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    public int countPrimes(int n) {
        if(n == 0 || n == 1) {
            return 0;
        }
        boolean[] isNotPrime = new boolean[n];

        isNotPrime[0] = true; // 1
        isNotPrime[1] = false; // 2
        int tmp = 0;
        for(int i = 2; i <= n; i++) {
            if(isNotPrime[i-1]) {
                // i is not prime
                continue;
            }
            tmp = 2 * i;
            while(tmp <= n) {
                isNotPrime[tmp - 1] = true;
                tmp += i;
            }
        }
        int counter = 0;
        for(int i = 0; i < n-1; i++) {
            counter += !isNotPrime[i] ? 1 : 0;
        }
        return counter;
    }
}
