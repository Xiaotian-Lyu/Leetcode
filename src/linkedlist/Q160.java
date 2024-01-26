package linkedlist;

import model.ListNode;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //A+B
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = (p1 != null) ? p1.next : headB;//错误写法：p1 = (p1 != null) ? p1.next : p2;
            p2 = (p2 != null) ? p2.next : headA;
        }
        return p1;//If there is no intersection , the last step will be :p1 = p1.next = null
    }
}
