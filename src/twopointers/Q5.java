package twopointers;

public class Q5 {
    class Solution {
        int left = 0, right = 0;
        int maxLen = 0;

        public String longestPalindrome(String s) {
            //traversal the string get exch char -> be the center
            for(int i = 0; i< s.length(); i++){
                //when the substring is odd
                helper(s, i , i);
                //substring is even
                helper(s, i, i+1);
            }

            return s.substring(left,right);
        }

        private void helper(String s,int i, int j){//全局变量 和 局部变量混乱
            while(i > 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            //compare the lence
            //注意出循环的i 和 j 不是正确的 left 和 right，都多移动了一位
            int len = j - i - 1;
            while(len > maxLen){
                maxLen = len;
                left = i + 1;
                right = j;
            }
        }

    }

}
