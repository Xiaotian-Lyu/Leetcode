package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            //cacaulate the good oranges and bad oranges
            int m = grid.length, n = grid[0].length;
            int count = 0 ;

            //错误答案：Queue<> queue = new Queue<>();
            Queue<int []> queue = new LinkedList<>();
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    if(grid[i][j] == 1){
                        count++; //good oranges
                    }else if(grid[i][j] == 2){
                        //put bad oranges into a queue
                        //错误写法 queue.put(int[]{i,j});
                        //错误写法 queue.add(int[]{i,j});
                        queue.add(new int[]{i,j});
                    }

                }
            }

            //check count 先判断又有没有好橘子
            if(count == 0) return 0;

            //pull bad oranges to do the BFS
            //错误写法 ：queue.pull();直接pull /写在循环外面也不对
            int[][] dirctions = {{1,0},{0,1},{-1,0},{0,-1}};

            //result
            int res = 0;
            //错误写法：queue.hasNext()
            while(!queue.isEmpty()){
                //add time +1
                res++;//先写在这里 因为后面要判断count 是否是0 是的话就返回 res
                int size = queue.size();

                for(int i=0 ;i < size;i++){
                    //错误写法 int[] pull = queue.pull();
                    int[] pull = queue.poll();

                    //DFS
                    for(int[] d: dirctions){
                        //exit of the recursion
                        //错误写法：int x = pull[0] + dirctions[0];
                        int x = pull[0] + d[0];
                        int y = pull[1] + d[1];

                        //错误写法 return - continue跳过这次循环 找下一个方向的int[] d
                        if( x< 0 || x >= m || y< 0 || y >= n || grid[x][y] != 1) continue;

                        //put the bad oranges into queue
                        //错误写法：queue.add(grid[x][y]);
                        queue.add(new int[] {x,y});

                        //change to 2
                        grid[x][y] = 2;
                        count--;

                        //check count
                        if(count == 0) return res;
                    }
                }
            }
            return -1;
        }
    }
}
