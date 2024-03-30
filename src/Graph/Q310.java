package Graph;

import java.util.*;

public class Q310 {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            //n==1
            //Given a tree of n nodes labelled from 0 to n - 1
            if(n==1){
                List<Integer> res = new ArrayList<>();
                res.add(0);
                return res;
            }

            //map store : node neighbors
            //错误写法：HashMap<Integer,Hashset<Integer>> map = new HashMap<>();
            Map<Integer,HashSet<Integer>> map = new HashMap<>();
            for(int[] edge : edges){
                //方法：putIfAbsent
                map.putIfAbsent(edge[0],new HashSet<>());
                map.putIfAbsent(edge[1],new HashSet<>());
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            //queue store the leaf nodes
            //错误写法：Queue<Integer> queue = new Queue<>();
            Queue<Integer> queue = new LinkedList<>();

            //方法：map.keySet()
            for(Integer e : map.keySet()){
                //错误写法：if(map.get[e].size() == 0) queue.add(e);
                if(map.get(e).size() == 1) queue.add(e);
            }

            List<Integer> res = new ArrayList<>(queue);//while 循环结束后能返回
            //BFS
            while(!queue.isEmpty()){
                //refresh the queue
                res = new ArrayList<>(queue);

                //traversal queue BFS
                int sizes = queue.size();
                //错误写法：for(int i ; i< sizes ; i++){
                for(int i = 0 ; i< sizes ; i++){
                    Integer e1 = queue.poll();
                    for(Integer e2: map.get(e1)){
                        map.get(e2).remove(e1);
                        if(map.get(e2).size()==1){
                            queue.add(e2);
                        }
                    }
                }
            }
            //queue is Empty the res = last leaf nodes
            return res;

        }
    }

}
