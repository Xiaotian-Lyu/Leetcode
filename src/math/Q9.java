package math;

public class Q9 {
    public boolean isPalindrome(int x) {
        //if negative return false
        if( x < 0) return false;

        int reverse = 0;
        int temp = x;
        while(temp != 0){
            int tail = temp % 10;//get the remainder -- tail 不能直接写reverse = tempt % 10
            reverse = reverse*10 + tail;
            temp /=10; //update the temp
        }
        return x == reverse;
    }
}
