package arraryandstring;

public class Q12 {
    class Solution {
        public String intToRoman(int num) {
            //create to correspond between. number - symbol
            String[] stringArray = {"M","CM", "D", "CD" ,"C" , "XC" ,"L" ,"XL" ,"X", "IX" ,"V", "IV", "I"};
            int[] intArray = {1000,900, 500, 400 ,100 , 90 ,50 ,40, 10 ,9, 5, 4, 1};

            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < intArray.length; i++){
                while(num >= intArray[i]){//要包括= 不然如果刚好1000 就不会出现M
                    num -= intArray[i];
                    builder.append(stringArray[i]);
                }
            }

            return builder.toString();


        }
    }
}
