package arrary;

public class Q283 {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[slow] = nums[fast];
//                fast++;
//                slow++;
//            }else{
//                  fast++;
//            }
//
//        }
        for (int i = slow; i < nums.length; i++) {
            nums[slow] = 0;
        }
    }
}
