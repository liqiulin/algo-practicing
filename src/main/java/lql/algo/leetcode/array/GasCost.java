//package lql.algo.leetcode.array;
//
//public class GasCost {
//    public static void main(String[] args) {
//        int[] gas  = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//
//    }
//
//    public int getStartStation(int[] gas, int[] cost)  {
//
//        int totalGas = 0;
//        int totalCost = 0;
//        int currentTank = 0;
//        int startStation = -1;
//        for (int i = 0; i < gas.length; i++) {
//            totalGas = totalGas + gas[i];
//            totalCost = totalCost + cost[i];
//
//            if (gas[i] - cost[i] < 0) {
//                currentTank = 0;
//                continue;
//            } else {
//                startStation = i;
//                currentTank = currentTank + gas[i] - cost[i];
//                currentTank = currentTank
//            }
//
//        }
//    }
//}
