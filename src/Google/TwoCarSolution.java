package Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoCarSolution {
    //给一个m*n大小的矩阵表示地图，两辆车a,b,目的地分别是A，B，地图上用'表示道路，'#'表示墙。
    //一辆车会阻隔另一辆车的行进，要求判断两辆车能否都到达目的地。
    //时间空间复杂度 O((m⋅n)2 因为有两辆车， queue 里面存的位置的可能性是 m * n * m * n;

    public boolean twoCarToTheEnd(String[] grid){
        int m = grid.length, n = grid[0].length();

        //find the position of a,b and A,B
        int ax = -1, ay = -1, bx = -1, by = -1;
        int Ax = -1, Ay = -1, Bx = -1, By = -1;

        //use visited map - store the every position
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i].charAt(j) == 'a'){
                    ax = i;
                    ay = j;
                }else if(grid[i].charAt(j) == 'b'){
                    bx = i;
                    by = j;
                }else if(grid[i].charAt(j) == 'A'){
                    Ax = i;
                    Ay = j;
                }else if(grid[i].charAt(j) == 'B'){
                    Bx = i;
                    By = j;
                }
            }
        }

        //BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ax, ay, bx, by});//start postion
        boolean[][][][] visited = new boolean[m][n][m][n];//二维数组用boolean[][]
        //为了初始化一个四维布尔数组，您需要指定每一维的大小

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] poll = queue.poll();

                for(int[] da : dirs){//这里需要两个for循环 因为a，b 可以分别向四个方向移动
                    for(int[] db : dirs){
                        int newax = poll[0] + da[0];
                        int neway = poll[1] + da[1];
                        int newbx = poll[2] + db[0];
                        int newby = poll[3] + db[1];

                        if(newax < 0 || neway < 0 || newax >= m || neway >= n ||
                                newbx < 0 || newby < 0 || newbx >= m || newby >= n ||
                                visited[newax][neway][newbx][newby] ||
                                grid[newax].charAt(neway) == '#' || grid[newbx].charAt(newby) == '#'){
                            //out of bound
                            continue;
                        }

                        if(newax == newbx && neway == newby){
//                            return false;// same position
                            continue;//只是遇到而已 不用return false
                        }

                        //不能交换位置
                        if(newax == poll[2] && neway == poll[3] && newbx == poll[0] && newby == poll[1]){
                            continue;
                        }

                        if((newax == Ax && neway == Ay) && (newbx == Bx && newby == By)){
                            //get to the A / B （可以有先后到达）
                            return true;
                        }

                        queue.add(new int[]{newax, neway, newbx, newby});
                        visited[newax][neway][newbx][newby] = true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TwoCarSolution test = new TwoCarSolution();
        String[] grid1 = {
                "a.A",
                "#.#",
                "b.B"
        };

        String[] grid2 = {
                "a.#A",
                "#####",
                "b..B"
        };

        String[] grid3 = {
                "aBAb"
        };


        System.out.println(test.twoCarToTheEnd(grid1));
        System.out.println(test.twoCarToTheEnd(grid2));
        System.out.println(test.twoCarToTheEnd(grid3));
    }
}
