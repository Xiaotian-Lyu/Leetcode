package Graph;

public class Q79 {
    class Solution2 {
        int m , n;
        boolean[][] visited;//record if visited

        public boolean exist(char[][] board, String word) {
            //**result， 公共的argument 可以在function 外面定义，
            //但是需要在 function 里面初始化** `exist` 方法可能会被多次调用，
            //每次传入不同的 `board`，如果在类中初始化 `m`、`n` 和 `visited`，
            //这些变量将保留上一次调用的值，导致数据混乱。每次调用 `exist` 方法时，
            //`m`、`n` 和 `visited` 都应该根据当前的 `board` 动态初始化。
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];//record if visited

            //traversal each postion
            for(int i = 0 ; i < m; i++){
                for(int j = 0 ; j < n; j++){
                    //create a new function to do the recursion
                    if(DFS(board, word, i, j, 0)) return true;

                }
            }

            return false;
        }

        //four directions
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        public boolean DFS(char[][] board, String word, int i, int j, int index){
            //exit of the recursion 错误写法：board[i][j] != word[index]
            if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == true || board[i][j] != word.charAt(index)){
                return false;
            }
            //不能忘记 如果找到了path
            if(index == word.length() - 1) return true;

            //change the status of postion
            visited[i][j] = true;

            //DFS for dirction
            for(int[] dir : directions){
                if(DFS(board, word, i + dir[0], j + dir[1], index + 1)) return true;
            }

            //change back
            visited[i][j] = false;

            return false;
        }
    }
    class Solution {
        public boolean exist(char[][] board, String word) {
            //traversal board[i][j]
            //int m = word.length(), n = word[0].length();
            int m = board.length, n = board[0].length;
            for(int i = 0; i< m ; i++){
                for(int j = 0; j< n ; j++){
                    //错误写法：if(helper(board, word, m,n,i,j,new int[i][j],0)){
                    //new boolean[m][n] 是创建了一个大小为 m 行 n 列的二维布尔型数组
                    if(helper(board, word, m,n,i,j,new boolean[m][n] ,0)){
                        return true;
                    }
                }
            }

            return false;

        }

        //DFS each directions ----- word-index == word.length() true
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        //错误写法 boolean visited
        private boolean helper(char[][] board, String word,int m,int n,int i,int j,boolean[][] visited,int index){
            //exit of the recursion
            if(index == word.length()) return true;
            //visited == true
            if(i < 0 || j < 0|| i >= m || j >= n || visited[i][j] || word.charAt(index) != board[i][j]) return false;

            //错误写法visited = true;
            visited[i][j] = true;

            for(int[] d : directions){
                //visited 是一个大小为 m 行 n 列的二维布尔型数组
                if(helper(board, word, m,n,i+d[0],j+d[1],visited,index+1)){
                    return true;
                }
            }
            //在深度优先搜索的过程中，当搜索一条路径后发现不符合要求
            //需要回溯到上一个位置，然后尝试其他路径。如果不将当前位置标记为未访问，可能会影响后续搜索的结果
            visited[i][j] = false;

            //遍历完四个方向都没有则返回false
            return false;
        }
    }
}
