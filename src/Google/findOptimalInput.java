package Google;

class OptimalInputFinder{
    public int findOptimalInput(int targetTime) {
        // write your code here
        //微波炉
        /**
         * Given that a microwave takes key stroke inputs and a target cooking time, find the optimal input considering the following costs for input:
         *
         * Input 999 will be interpreted as 9 minutes 99 seconds.
         * Input 81 as 81 seconds.
         * Input 1221 as 12 minutes 21 seconds.
         * The cost of each key stroke is 1, and the cost of moving the finger to a different key is 2. For example, input 999 has a cost of 3, input 1122 has a cost of 6, and input 1234 has a cost of 10.
         *
         * The input has to be within 10% of the target time. If the cost is the same, select the input that's closest to the target time.
         *
         * For example, for a target time of 10 minutes, 888 is the optimal input (not 999).
         * Input:  targetTime = 600
         * Output: 888
         * Explanation:
         For a target time of 10 minutes (600 seconds),
         the optimal input is 888, which is interpreted as 8 minutes 88 seconds or 528 seconds.
         This is within 10% of the target time and has a lower cost than 999 (which would be 9 minutes 99 seconds or 599 seconds).
         *
         */
        int minTarget = (int)(targetTime * 0.9);
        int maxTarget = (int)(targetTime * 1.1);

        int minCost = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;
        int res = -1;

        for(int i = 0; i <= 9999; i++){
            int minit = i / 100;
            int seconds = i % 100;
            int time = minit * 60 + seconds;

            if(time > maxTarget || time < minTarget){
                continue;
            }

            String timeOfString = String.valueOf(i);
            int cost = timeOfString.length();
            for(int j = 1; j < timeOfString.length(); j++){//不能是cost cost 会变
//                System.out.println(j + " " + timeOfString + " " + cost + " " + timeOfString.length());
                if(timeOfString.charAt(j) != timeOfString.charAt(j - 1)){
                    cost += 2;
                }
            }

            int dis = Math.abs(targetTime - time);
            if(cost < minCost || (cost == minCost && dis < minDis)){//minCost 和 minDis 是一一对应的
                minCost = cost;
                minDis = dis;
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OptimalInputFinder finder = new OptimalInputFinder();
        int targetTime = 600;
        System.out.println(finder.findOptimalInput(targetTime));  // 输出应为888
    }

}
