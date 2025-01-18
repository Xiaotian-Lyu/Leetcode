package Google;

import java.util.*;

public class reachTheEndSolution {
    public String reachTheEnd(String[] grid, int maxTime) {
        // write your code here
        //BFS - OA
        int m = grid.length, n = grid[0].length();//String[] grid 是一围数组
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});//start here
        boolean[][] visited = new boolean[m][n];
        //Set<int[]> map = new HashSet<>();//这里应该用Set
        //not map should be set but int[] is a address not suitable
        //so better be visited
        // map.put(new int[]{0, 0});//store the position

        int time = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] poll = queue.poll();
                //find next
                for(int[] d : dirs){
                    int x = d[0] + poll[0];
                    int y = d[1] + poll[1];
                    int[] next = new int[]{x, y};
                    if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] == true || grid[x].charAt(y) == '#'){
                        continue;
                    }
                    if(x == m - 1 && y == n - 1){//reach the end
                        time += 1;//finish last step
                        return time <= maxTime ? "Yes" : "No";
                    }
                    queue.add(next);
                    visited[x][y] = true;
                }
            }
            time++;//finish one layer
        }
        return "No";
    }

    public static void main(String[] args){
        reachTheEndSolution test1 = new reachTheEndSolution();
        System.out.println(test1.reachTheEnd(new String[] { "..#", "#.##", "#..." }, 5));

        reachTheEndSolution test2 = new reachTheEndSolution();
        System.out.println(test1.reachTheEnd(new String[] { "..#", "#.##", "#..." }, 2));
    }
}
