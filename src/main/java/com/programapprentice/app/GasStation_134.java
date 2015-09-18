package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/13/15
 * Time: 10:40 PM
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0) { // wrong: if(gas == null || gas.length == 1) {
            return -1;
        }
        int totalGas = 0;
        int totalCost = 0;
        int pre = 0;
        int startIdx = 0;
        for(int i = 0; i < gas.length; i++) {
            pre += gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
            if(pre < 0) {
                pre = 0;
                startIdx = i + 1;
            }
        }
        return totalGas >= totalCost ? startIdx : -1; // wrong:return totalGas > totalCost ? startIdx : -1;
    }
}
