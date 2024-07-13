package Greedy;

public class Q134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            //check if can finish all circle
            int gastotal = 0;
            int costtotal = 0;
            for(int i = 0; i < gas.length; i++){
                gastotal += gas[i];
                costtotal += cost[i];
            }
            if(costtotal > gastotal) return -1;

            //find the stat index
            int start = 0;
            int curGas = 0;
            for(int i = 0 ; i < gas.length ; i++){//这里不会i++？
                curGas += gas[i] - cost[i];
                if(curGas < 0){
                    //can not start with that i;start again
                    curGas = 0;
                    start = i + 1;
                }

            }
            return start;
        }
    }
}
