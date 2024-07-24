package arraryandstring;

public class Q151 {
    class Solution {
        public String reverseWords(String s) {
            //remove the space in the front and end
            s = s.trim();

            //split string
            String[] words = s.split("\\s+");

            //reverce string[]
            int left = 0, right = words.length - 1;
            while(left < right){
                String temp = words[left];
                words[left] = words[right];
                words[right] = temp;
                left++;
                right--;
            }

            //join the string[]
            return String.join(" ", words);

        }
    }
}
