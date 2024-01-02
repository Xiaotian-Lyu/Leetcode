package binarysearch;

import java.util.TreeMap;

public class Q278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left);
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left = left + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }


}
