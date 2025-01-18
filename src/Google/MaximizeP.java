package Google;

import java.util.HashMap;
import java.util.Map;

public class MaximizeP {
    public int maximizePoints(int[] points) {
        // write your code here
        //dp 和抢劫房子不一样
        /**
         * Input:  points = [25, 1, 3, 99, 4]
         * Output: 100
         * Explanation:Take 1 and 99, the solution is 100.
         * Given an array, each value at each index represents points.
         * If you "take" the points at value v, you can't take the points in the next v indices.
         * Maximize the amount of points you can take.
         */
        int n = points.length;

        if (n == 0) return 0;
        if (n == 1) return points[0];

        int[] dp = new int[n + 1];//dp[i]表示从i开始--到最后之间的最大点数 //空间复杂度O(n)
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){ //时间复杂度O(n)
            int take = points[i];
            if(i + points[i] < n){
                take += dp[i + points[i] + 1];
            }
            dp[i] = Math.max(take, dp[i + 1]);
        }
        return dp[0];
    }

    public int maximizePoints2(int[] points) {
        // write your code here 用recursion
        //DFS + Map
        Map<Integer, Integer> map = new HashMap<>();//map 用来提高效率 //空间复杂度O(n)
        //由于我们使用了 Map 来存储每个 index 的计算结果（记忆化搜索），每个 index 只会被计算一次。--时间复杂度O(n)
        return dfs(points, 0, map);//index 是0依赖于后面的，刚好就是可以用recursion逐步完成
    }

    public int dfs(int[] points,int index, Map<Integer, Integer> map){
        //exit of the recursion
        if(index >= points.length){
            return 0;
        }

        if(map.containsKey(index)){
            return map.get(index);
        }

        int notTake = dfs(points, index + 1, map);//取到index，这里是index + 1 因为前面取决于后面

        int nextIndex = index + points[index] + 1;//不取到index
        int takeHere = points[index] + dfs(points, nextIndex, map);

        int max = Math.max(notTake, takeHere);
        map.putIfAbsent(index, max);//store the index = dp array
        return max;
    }

    public static void main(String[] args){
        MaximizeP test = new MaximizeP();
        System.out.println(test.maximizePoints(new int[]{25, 1, 3, 99, 4}));  // 输出应为9

        System.out.println(test.maximizePoints2(new int[]{25, 1, 3, 99, 4}));
    }
}
