package linkedlist;

import model.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        //two listnode: left-small , right-bigger and equal
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        //two tail
        ListNode leftTail = left;
        ListNode rightTail = right;

        //traversal all the head
        while(head != null){ //错误写法：head.next != null 要遍历所有值所以最后一位head.next == null
            //compare the head.value to x
            if(head.val < x){//错误写法：head.value
                leftTail.next = head;
                leftTail = leftTail.next;//update the leftTail
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;//update the head
        }

        leftTail.next = right.next;//comeby two list node
        rightTail.next = null;

        return left.next;
    }
}
