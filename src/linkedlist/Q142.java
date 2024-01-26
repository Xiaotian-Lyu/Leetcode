package linkedlist;

import model.ListNode;

public class Q142 {
    public ListNode detectCycle(ListNode head) {
        //fast and slow meet in the first time
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){//meet 1:the circle = slow
                //fast.val == slow.val在这个快慢指针的算法中，我
                //们主要比较的是节点的引用（地址），而不是节点的值。
                //在链表中，节点的值可以相同，但节点的地址是唯一的。
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;//为什么不是return -1？？？？？？？ Note that pos is not passed as a parameter.？？？？？
    }
}
