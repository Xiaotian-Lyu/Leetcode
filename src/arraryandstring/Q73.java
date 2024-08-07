package arraryandstring;

import java.util.HashSet;
import java.util.Set;

public class Q73 {
    public class SolutionDontInPalce {
        public void setZeroes(int[][] matrix) {
            Set<Integer> zeroRows = new HashSet<>();
            Set<Integer> zeroCols = new HashSet<>();

            int m = matrix.length;
            int n = matrix[0].length;

            // First pass to find all rows and columns that need to be zeroed
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRows.add(i);
                        zeroCols.add(j);
                    }
                }
            }

            // Zero out rows
            for (int row : zeroRows) {
                for (int j = 0; j < n; j++) {
                    matrix[row][j] = 0;
                }
            }

            class Solution2 {
                public void setZeroes(int[][] matrix) {
                    int m = matrix.length - 1;//rows
                    int n = matrix[0].length - 1;//cols
                    boolean firstRow = false;
                    boolean firstCol = false;

                    //check first row col if contains 0, mark
                    for (int i = 0; i <= n; i++) {
                        if (matrix[0][i] == 0) {//行 = 0
                            firstRow = true;
                            break; //找到一行就出循环
                        }
                    }
                    for (int i = 0; i <= m; i++) {
                        if (matrix[i][0] == 0) {//列 = 0
                            firstCol = true;
                            break;//找到一列就出循环
                        }
                    }

                    //traversal the matrix, if contains 0, mark on the first row/col
                    for (int i = 1; i <= m; i++) {//先遍历行 一共m行
                        for (int j = 1; j <= n; j++) {//再遍历列，一共n列

                            if (matrix[i][j] == 0) {
                                matrix[i][0] = 0;
                                matrix[0][j] = 0;
                            }
                        }
                    }


                    //traversal again to change the row/col to 0
                    for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                                matrix[i][j] = 0;
                            }
                        }
                    }

                    //change the first row/col to 0
                    if (firstRow) {
                        for (int i = 0; i <= n; i++) {
                            matrix[0][i] = 0;
                        }
                    }
                    if (firstCol) {
                        for (int i = 0; i <= m; i++) {
                            matrix[i][0] = 0;
                        }
                    }


                }
            }
            class Solution {
                public void setZeroes(int[][] matrix) {
                    int m = matrix.length - 1;//rows
                    int n = matrix[0].length - 1;//cols
                    boolean firstRow = false;
                    boolean firstCol = false;

                    //check first row col if contains 0, mark
                    for (int i = 0; i <= n; i++) {
                        if (matrix[0][i] == 0) {//行 = 0
                            firstRow = true;
                            break; //找到一行就出循环
                        }
                    }
                    for (int i = 0; i <= m; i++) {
                        if (matrix[i][0] == 0) {//列 = 0
                            firstCol = true;
                            break;//找到一列就出循环
                        }
                    }

                    //traversal the matrix, if contains 0, mark on the first row/col
                    for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (matrix[i][j] == 0) {
                                matrix[i][0] = 0;
                                matrix[0][j] = 0;
                            }
                        }
                    }


                    //traversal again to change the row/col to 0
                    for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                                matrix[i][j] = 0;
                            }
                        }
                    }

                    //change the first row/col to 0
                    if (firstRow) {
                        for (int i = 0; i <= n; i++) {
                            matrix[0][i] = 0;
                        }
                    }
                    if (firstCol) {
                        for (int i = 0; i <= m; i++) {
                            matrix[i][0] = 0;
                        }
                    }


                }
            }
        }
    }
}