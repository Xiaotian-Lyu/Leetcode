package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    /**
     * Time Complexity
     * To determine the time complexity, let's consider the process:
     *
     * Each digit in the input string can map to 3 or 4 possible letters (2 maps to "abc", 3 maps to "def", 7 maps to "pqrs", etc.).
     * If the input string digits has length n, and each digit maps to an average of 4 letters, the total number of combinations is 4^n.
     * Each combination is built in a recursive manner, and building each combination takes O(n) time since we need to traverse the entire length of the combination to append it to the result list.
     * Therefore, the time complexity is: 4^n * n
     *
     * Space complexity: O(N), where N is the length of digits.空间复杂度是额外的空间
     */
    class Solution {
        //array corresbonding - digits and letters
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if(digits.length() == 0) return res;
            //错误写法：new Stringbuilder
            help(res, digits, new StringBuilder(), 0);//backtracing;
            return res;
        }

        //backtracing; --- recursion
        private void help(List<String> res, String digits, StringBuilder builder, int index){
            //exit of the recursion
            if( index == digits.length()){
                //错误写法：res = builder.append();
                res.add(builder.toString());
                return;
            }
            char digit = digits.charAt(index);
            //错误写法：letters.[digit - "0"]
            for(char next : letters[digit - '0'].toCharArray()){
                builder.append(next);
                help(res, digits, builder, index + 1);
                //错误写法：builder.getLength
                builder.setLength(builder.length() - 1);
            }
        }
    }
}
