package arraryandstring;

public class Q58 {
    public int lengthOfLastWord(String s) {
        String words = s.trim();//remove the space in the front side and back side

        int length = 0;//the length Of Last Word
        for(int i = words.length() - 1; i >= 0; i--){
            //if meet space break
            if(words.charAt(i) == ' ') break;//双引号是string 单引号是Char
            length++;
        }

        return length;

    }
}
