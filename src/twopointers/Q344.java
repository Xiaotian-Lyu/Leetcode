package twopointers;

public class Q344 {
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length -1;
            while(left < right){
                //swap
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }

        }
    }

}
