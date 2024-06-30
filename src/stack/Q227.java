package stack;

import java.util.Stack;

public class Q227 {
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
