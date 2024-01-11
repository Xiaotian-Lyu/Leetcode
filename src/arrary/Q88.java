package arrary;

public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;//index of nums1
        int j = n - 1;//index of nums2
        int k = m + n - 1;//index of new array

        //two poniters
        while (j >= 0) {//>= 不是 > =
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];//nums1[k] = nums1[j];k--,i--;???????
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
