package Google;

class OptimalInputFinder{
    public int findOptimalInput(int targetTime) {
        // write your code here
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
            if(cost < minCost || (cost == minCost && dis < minDis)){
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
        System.out.println(finder.findOptimalInput(targetTime));  // 输出应为1000
    }

}
