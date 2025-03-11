package Amazon;

import java.util.*;

public class lotteryfunction {
    class solution1{
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Random random = new Random();

        public void addToPool(String id, int n){
//        this.map.put(id, n);不应该这样更新
            this.map.put(id, map.getOrDefault(id, 0) + n);
            for (int i = 0; i < n; i++) {
                this.list.add(id);
            }
        }
        public String pickLottery(){
            int pickIndex = random.nextInt(list.size());
            return  list.get(pickIndex);
        }
    }

    class solution2{
        Random random = new Random();
        List<String> users = new ArrayList<>();//需要用来fill PreSum
        int[] preSum;
        Map<String,Integer> map = new HashMap<>();
        //维护一个totaltickets
        int totalTickets;

        public solution2(){
            //build the preSum
//            buildPreSum();？？？？
        }

        public void addToPool(String id, int n){
            map.put(id, map.getOrDefault(id, 0) + n);
            if(!users.contains(id)){
                users.add(id);
            }
            buildPreSum();
            //如果要新增 addToPool(String id, int n) 方法，让用户可以动态增加购票数，我们需要 更新 userTickets、重新计算 preSum，并更新 totalTickets。
        }

        public String pickID(){
            int pick = random.nextInt(totalTickets) + 1;
            int left = 0, right = preSum.length - 1;

            while (left < right){
                int mid = left + (right - left) /2;
                if(preSum[mid] >= pick){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return users.get(left);
        }

        public void buildPreSum(){
            this.preSum = new int[users.size()];
            int sum = 0;
            for (int i = 0; i < users.size(); i++) {
//                sum += users.get(i);这里不对
                sum += map.get(users.get(i));
                preSum[i] = sum;
//                this.totalTickets = preSum[i];//得到总数
            }
            totalTickets = sum;
        }


    }

}
