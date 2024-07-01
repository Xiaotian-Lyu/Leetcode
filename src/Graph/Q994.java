package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    class Solution2 {
        public int orangesRotting(int[][] grid) {
            //traversal all the grid find the 2 ,and calculate the 1
            int m = grid.length, n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int goodOranges = 0;

            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    if(grid[i][j] == 2){
                        //put the 2 into a queue
                        queue.add(new int[]{i,j});

                    }else if(grid[i][j] == 1){
                        goodOranges++;
                    }
                }
            }

            if(goodOranges == 0) return 0;//if have no good oranges already

            int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
            int reusltTime = 0;
            //BFS to change 2 near good oranges and calculate the time

            while(!queue.isEmpty()){

                int size = queue.size();
                reusltTime++;

                //poll the first layer of bad oranges
                for(int i = 0; i < size; i++){

                    //To find the good oranges
                    int[] poll = queue.poll();

                    for(int[] direction : directions){
                        int x = poll[0] + direction[0];
                        int y = poll[1] + direction[1];

                        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) continue;

                        //不要忘记把坏橘子继续放入queue
                        queue.add(new int[]{x,y});

                        grid[x][y] = 2;
                        goodOranges--;

                        if(goodOranges == 0) return reusltTime;
                    }

                }

            }
            //check if still has good oranges
            // if(goodOranges == 0) return reusltTime；
            //不能把判断时间写在queue 空了之后，因为例题1 第四分钟的时候queue 里面是 有最后坏的橘子的
            //它需要再进循环找一下附近有没有1 呐会出不了循环吗？？？
            //这样就导致了结果总是多一分钟
            //goodOranges--之后直接判断是否是0 就返回就行

            //return result
            return -1;

        }
    }
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
