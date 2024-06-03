package Graph;

public class Q130 {
    class Solution {
        //two types of 'O'
        //DFS with the border and mark the order'O' to 'T'
        //traversal all - 'O' to 'X' ; 'T' to 'O'

        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};

        public void solve(char[][] board) {
            int m = board.length, n = board[0].length;
            for(int i = 0; i < m ; i++){
                dfs(board, i , 0);
                dfs(board, i , n - 1);
            }
            for(int j = 0; j < n ; j++){
                dfs(board, 0 , j);
                dfs(board, m - 1 , j);
            }
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n ; j++){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }else if(board[i][j] == 'T'){
                        board[i][j] = 'O';
                    }

                }

            }


        }

        private void dfs(char[][] board, int i, int j){
            int m = board.length, n = board[0].length;
            //exit of the recursion
            if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
            //find the O change to T
            board[i][j] = 'T';
            for(int[] dir : dirs){
                dfs(board, i + dir[0], j + dir[1]);
            }
        }

    }
}
