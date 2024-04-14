package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q542 {
    class Solution2 {
        public int[][] updateMatrix(int[][] mat) {
            //queue - store 0
            //boolean[][] - store the visited
            int m = mat.length, n = mat[0].length;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();

            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    if(mat[i][j] == 0){
                        queue.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }

            //distance = 0
            int distance = 0;
            int[][] dirctions = {{1,0},{-1,0},{0,1},{0,-1}};
            //BFS - four dirctions find the next layer
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size ; i++){
                    int[] poll = queue.poll();
                    //mark the distance
                    mat[poll[0]][poll[1]] = distance;
                    for(int[] dir : dirctions){
                        int x =  poll[0] + dir[0], y = poll[1] + dir[1];
                        //check the state
                        if( x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                        visited[x][y] = true;
                        //add the next layer into queue
                        queue.add(new int[]{x,y});
                    }

                }
                distance++;
            }

            return mat;

        }
    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            //queue - store all the 0
            //map - of visited
            //int[]: 这是一个一维数组 int[][]: 这是一个二维数组
            Queue<int[]> queue = new LinkedList<>();
            int m = mat.length, n = mat[0].length;
            //错误写法：boolean[][] visited = new int[m][n];
            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i< m ; i++){
                for(int j = 0; j< n ; j++){
                    if(mat[i][j] == 0){
                        //错误写法：queue.put(new int[]{i,j});
                        queue.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }

            int distance = 0;
            int[][] dirctions = {{-1,0},{0,-1},{1,0},{0,1},};
            //BFS - traversal the queue - store the 1 near the 0 - store the 1 near the 1

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i< size ; i++){
                    int[] poll = queue.poll();
                    //set the distance - mat 是一个二维数组
                    mat[poll[0]][poll[1]] = distance;
                    for(int[] direction : dirctions){
                        int x = poll[0]+direction[0], y = poll[1] + direction[1];
                        //if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == true ) continue;
                        queue.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
                distance++;
            }
            return mat;
        }
    }
}
