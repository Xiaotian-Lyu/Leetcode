package hashtable;

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    //has two solution
    //1.two pointers 在linkedList里<>
    //2.hashmap use recursion

    //a set to store the value
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        //end of recursion: n -> cal(n) -> cal(cal(n))  ===> 1 or loop
        if (n == 1) return true;
        if (set.contains(n)) return false;
        //add the value into set
        set.add(n);
        int next = square(n);
        return isHappy(next);

    }

    public int square(int n) {
        int answer = 0;
        while (n > 0) {
            int remainder = n % 10;
            answer += remainder * remainder;
            n /= 10;
        }
        return answer;
    }


}
