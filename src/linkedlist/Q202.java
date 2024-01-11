package linkedlist;

public class Q202 {
    //has two solution
    //1.two pointers
    //2.hashmap 在hashtable里<>
    public boolean isHappy(int n) {
        //two pointers
        int slow = n;
        int fast = square(n);
        // when fast and slow meet has two condition
        // 1.there is a circle ——> slow = fast != 1
        // 2.there is no circle: fast and slow meet in the end slow = fast = 1
        while(slow != fast){
            slow = square(slow);//slow one step
            fast = square(square(fast));//fast two steps
        }
        return slow == 1;
    }

    public int square(int n) {
        int answer = 0;
        while (n > 0) {
            int remainder = n % 10;// 取余数
            answer += remainder * remainder;
            n /= 10;// = n= n/10(自取整) 比如 m += 1(自加); m= m+1
        }
        return answer;
    }
}
