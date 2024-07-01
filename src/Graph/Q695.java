package Graph;

public class Q695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            //get the boundary of the grid
            int m = grid.length, n = grid[0].length;

            int maxArea = 0;

            //traversal the gird check 1
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        //DFS that 1, to find all the near 1,and check the maxarea
                        maxArea = Math.max(maxArea, DFS(grid, i, j, m, n));
                    }
                }
            }

            return maxArea;

        }

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        //function => DFS return the maxarea of each 1
        public int DFS(int[][] grid, int i, int j, int m, int n){
            //exit of the recursion
            if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;//注意这里要return 0

            //change the 1 -> 0
            grid[i][j] = 0;

            //calculate the number area
            int area = 1;

            //recursion - four dirction
            for(int[] drection : directions){
                area += DFS(grid, i + drection[0], j+ drection[1], m, n);
            }

            //return result
            return area;

        }
    }
}
