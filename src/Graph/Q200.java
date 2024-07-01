package Graph;

public class Q200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int result = 0;
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    //错误写法：if(grid[i][j] == 1){
                    if(grid[i][j] == '1'){
                        result++;
                        DFS(grid, i, j, m, n);
                    }
                }
            }

            return result;

        }

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        public void DFS(char[][] grid, int i, int j, int m, int n){
            //exit of the recursion
            //错误写法：if(i < 0 || j < 0 || i > m || j > n || grid[i][j] == '0') return;
            if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;

            //change the 1 to 0
            grid[i][j] = '0';

            for(int[] direction : directions){
                DFS(grid, i + direction[0], j + direction[1], m, n);
            }

        }
    }
    public int numIslands(char[][] grid) {
        //Initialize variables
        int res = 0, m = grid.length, n = grid[0].length;

        //traversal each point to check if is 1
        //res++
        // change 1 to 0
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == '1'){
                    res++;
                    //check the neighbor
                    //错误写法：dfs(grid[i][j]);
                    dfs(grid,i,j,m,n);
                }
            }
        }

        return res;
    }

    //direct
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    //错误写法 private void dfs(char[][] grid)
    private void dfs(char[][] grid,int i,int j,int m,int n){

        //exit of the recursion to find '1'
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;

        //不要忘记改值
        grid[i][j] = '0';

        for(int[] d :directions){
            dfs(grid, i+ d[0] , j+d[1] ,m ,n );
        }
    }
}
