package arraryandstring;

public class Q8 {
    class Solution {
        public int myAtoi(String s) {
            int i = 0;

            //traversal s check " "
            while(i < s.length() && s.charAt(i) == ' '){//char 不是String
                i++;
            }

            // Check if the string is empty after skipping whitespaces
            if (i == s.length()) return 0;

            //check the + or -
            boolean nagative = false;
            if(i < s.length() && s.charAt(i) == '-'){//这里不能用while loop？
                nagative = true;
                i++;
            }else if (i < s.length() && s.charAt(i) == '+'){//？
                i++; //不能忘记！！
            }


            //check the digit
            long result = 0;//错误Long result = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                char c = s.charAt(i);
                result = result * 10 + (c - '0');
                if(result > Integer.MAX_VALUE){//不能写=
                    if(nagative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                i++;
            }

            if(nagative){
                return -(int)result;
            }

            return (int)result;
        }
    }
}
