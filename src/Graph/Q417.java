package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            //find all the borders cell , record with a boolean boolean[][]
            int m = heights.length, n = heights[0].length;
            //错误boolean[][] pacificFlow = new int[m][n];
            boolean[][] pacificFlow = new boolean[m][n];
            boolean[][] atlanticFlow = new boolean[m][n];

            //DFS the borders cell
            for(int i = 0; i < m ; i++){
                // DFS(heights, pacificFlow, i , 0 , m , n);
                // DFS(heights, atlanticFlow, i , m - 1 , m , n);
                DFS(heights, pacificFlow, i , 0 , m , n);
                DFS(heights, atlanticFlow, i , n - 1 , m , n);
            }

            for(int j = 0; j < n ; j++){
                // DFS(heights, pacificFlow, 0 , j , m , n);
                // DFS(heights, atlanticFlow, m - 1 , j , m , n);
                DFS(heights, pacificFlow, 0 , j , m , n);
                DFS(heights, atlanticFlow, m - 1 , j , m , n);
            }

            //check the two boolean int[][] which cell two ocean can both flow
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    if(pacificFlow[i][j] == true && atlanticFlow[i][j] == true){
                        //错误：result.add(new ArrayList<>(i,j));
                        result.add(Arrays.asList(i,j));
                    }
                }
            }
            return result;


        }

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        //DFS to check the neighboring cells if can flow
        public void DFS(int[][] heights, boolean[][] oceanFlow, int i, int j, int m, int n){
            //exit of the recursion
            if(oceanFlow[i][j] == true) return;

            //change the status
            oceanFlow[i][j] = true;

            //get the new x,y
            for(int[] direction : directions){
                int x = i + direction[0];
                int y = j + direction[1];

                //check the boundary
                //错误：if(x >= 0 && y >= 0 && x < m &&  y < n && oceanFlow[x][y] != true && oceanFlow[x][y] >= oceanFlow[i][j]){
                if(x >= 0 && y >= 0 && x < m &&  y < n && oceanFlow[x][y] != true && heights[x][y] >= heights[i][j]){
                    DFS(heights, oceanFlow, x, y, m, n);
                }

            }


        }
    }
}
