package arraryandstring;

public class Q66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            //traversal the digits check if digit < 9: + 1
            for(int i = digits.length - 1; i >= 0; i--){
                if(digits[i] < 9){
                    digits[i] = digits[i] + 1;
                    return digits;
                }
                //digit = 9:change = 0
                digits[i] = 0;
            }

            //digits all 9: create a new result to return => index 0 = 1
            int[] result = new int[digits.length + 1];
            result[0] = 1;//others defalt 0
            return result;

        }
    }
}
