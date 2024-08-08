package stack;

import java.util.Stack;

public class Q227 {
    class Solution3{
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 跳过空格
                if (c == ' ') continue;

                // 处理数字
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    // 如果下一个字符不是数字或者已经到达字符串末尾，执行操作
                    if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                        switch (sign) {
                            case '+' -> stack.push(num);
                            case '-' -> stack.push(-num);
                            case '*' -> stack.push(stack.pop() * num);
                            case '/' -> stack.push(stack.pop() / num);
                        }
                        num = 0;  // 重置 num
                    }
                } else {  // 处理符号
                    sign = c;
                }
            }

            // 计算栈中的结果
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }

            return result;
        }

    }
    class Solution2 {
        public int calculate(String s) {
            //Stack -> put all the numbers
            Stack<Integer> stack = new Stack<>();
            char sign = '+'; //put the operater default +
            int number = 0;

            //traversal s
            for(int i = 0 ; i < s.length(); i++){
                //get the number
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    number = c - '0';
                    //确保在检查下一个字符是否为数字之前检查边界：在 while 循环中，应该先检查 i + 1 < s.length()
                    //再检查 Character.isDigit(s.charAt(i + 1))，否则在字符串末尾会导致越界错误。
                    while( i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                        number = number * 10 + (s.charAt(i+1)-'0');
                        i++;
                    }
                }
                //check the sign - not digit or the last char
                if(!Character.isDigit(c) && c != ' ' || i == s.length() - 1){
                    switch(sign){//check the sign before update
                        case'+' -> stack.push(number);
                        case'-' -> stack.push(-number);
                        case'*' -> stack.push(stack.pop() * number);
                        case'/' -> stack.push(stack.pop() / number);
                    }
                    sign = c;
                }
            }

            //add all numbers in stack
            int result = 0;
            while(!stack.isEmpty()){
                result += stack.pop();
            }
            return result;
        }
    }
    class Solution {
        public int calculate(String s) {
            //stack -> number ; sign -> default'+' ; number ->full number
            Stack<Integer> stack = new Stack<>();
            Character sign = '+';
            int number = 0;
            for(int i = 0; i < s.length(); i++){//这里只能用 for-i 因为我要同时检查下一个character
                Character c = s.charAt(i);
                // int number = 0;  也不能写在这里因为只能在大括号里生效 没法进入下一个循环 number 一直被重新赋值0
                //get the whole number
                if(Character.isDigit(c)){
                    // int number = c = '0';number 写在这里只有在if 循环里能被看见;要在外面定义
                    number = c - '0';
                    while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){//next is digit too
                        number = number * 10 + (s.charAt(i+1)-'0');
                        i++;
                    }
                }
                //check if meet the operater
                if(!Character.isDigit(c) && c != ' '|| i == s.length()-1 ){
                    switch(sign){//check the old sign
                        case '+' -> stack.push(number);
                        case '-' -> stack.push(-number);
                        case '*' -> stack.push(stack.pop() * number);
                        case '/' -> stack.push(stack.pop() / number);
                    }
                    sign = c;
                }
            }
            //add all the numbers in stack
            int result = 0;
            while(!stack.isEmpty()){
                result += stack.pop();
            }

            return result;
        }
    }
}
