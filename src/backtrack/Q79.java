package backtrack;

public class Q79 {
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

            return false;//全部遍历完 没有返回true 则 是false

        }

        //DFS each directions ----- word-index == word.length() true
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        //错误写法 boolean visited
        private boolean helper(char[][] board, String word,int m,int n,int i,int j,boolean[][] visited,int index){
            //exit of the recursion
            if(index == word.length()) return true;
            //visited == true 的时候说明已经访问过切没有其他true的情况了 则找不到对应的字母就返回false
            //visited[i][j] 不能省略 会有例外的情况：有重复字母的时候
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
