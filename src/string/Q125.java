package string;

public class Q125 {
    public boolean isPalindrome(String s) {
        int i = 0;//first letter
        int j = s.length() - 1;//the last letter

        //while the s is empty i = 0, j = -1,will not in to the while loop
        //nature return true
        while (i < j) {
            while (i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;// is the first letter or digit?
            }
            while (i<j&& !Character.isLetterOrDigit(s.charAt(j))){
                j--;// is the last letter or digit?
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){//transfer to the lower case
                return false;
            }
            i++;//compare the next
            j--;//compare the next
        }
        return true;
    }
}
