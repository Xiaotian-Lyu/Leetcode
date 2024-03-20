package Graph;

public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //check the start image[sr][sc] == color ?
        if(image[sr][sc] == color) return image;

        //need a helper to do the recursion
        helper(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    //set the direction
    int[][] direction = {{-1,0},{0,1},{0,-1},{1,0}};

    private void helper(int[][] image, int m, int n, int newcolor, int oldcolor){
        //the exit of the recursion
        //错误答案：image[m][n] == newcolor
        //错误答案：n >= image.length
        if(m < 0 || n < 0 || m >= image.length || n >= image[0].length || image[m][n] != oldcolor) return;

        //change color
        image[m][n] = newcolor;

        //traversal the all direction
        for(int[] d : direction){
            helper(image,m + d[0],n + d[1],newcolor,oldcolor);
        }
    }
}
