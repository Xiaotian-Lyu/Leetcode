package binarysearch;

import java.util.TreeMap;

public class Q278 {
    //find the minimum value that satisfied the condition
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left);
            if (isBadVersion(mid)){
                right = mid;
            }else {//如果不是bad version 要往右边找
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }


}
