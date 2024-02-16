package binarysearch;

public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find the target - binary reaserch
        //need two index: x y to find the value of mid
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int right = m * n - 1;//闭区间

        while(left <= right){
            int mid = left + (right - left)/2;
            int x = mid/n , y = mid % n;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                left = mid + 1;
            }else if(matrix[x][y] > target){
                right = mid - 1;
            }
        }
        return false;

    }
}
