package bitmanipulation;

public class Q67 {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int indexA = a.length() - 1;
            int indexB = b.length() - 1;
            int carry = 0;

            while(indexA >= 0 || indexB >= 0 || carry > 0){
                int sum = carry;//错误写法：int sum = 0;

                //sum + A
                if(indexA >= 0){
                    sum += a.charAt(indexA) - '0';
                    indexA--;
                }

                //sum + B
                if(indexB >= 0){
                    sum += b.charAt(indexB) - '0';
                    indexB--;
                }

                //get the carry
                carry = sum / 2;

                //add to result
                result.append(sum % 2);
            }

            return result.reverse().toString();
        }
    }
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); // 用于存储最终结果的StringBuilder
        //用StringBuilder 是因为比String效率更高
        int carry = 0; // 进位的初始值为0

        int i = a.length() - 1; // 从a的最低位开始
        int j = b.length() - 1; // 从b的最低位开始

        while (i >= 0 || j >= 0 || carry > 0) {//carry > 0 用处
            int sum = carry; // 将当前进位加到sum中

            // 如果a的位数还没有遍历完，将a当前位的值加到sum中
            if (i >= 0) {
                sum += a.charAt(i--) - '0';//charAt拿到的是字符，转成数字就是减去0
            }

            // 如果b的位数还没有遍历完，将b当前位的值加到sum中
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // 将当前位的结果插入到结果StringBuilder的最前面
            result.insert(0, sum % 2);

            // 更新进位
            carry = sum / 2;
        }

        return result.toString(); // 返回最终结果
    }
}
