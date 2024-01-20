package linkedlist;

import model.ListNode;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        //calculate the length of the listNode; and the tail of the linked list
        int length = 1;
        ListNode tail = head;
        while( tail.next != null){
            length++;
            tail = tail.next;
        }

        //make a circle
        tail.next = head;

        //calculate the steps after circle
        k = k%length;

        //find the newTail: the listNode before K
        ListNode newTail = head;//initialize the newTail
        for(int i = 1; i <= length-k-1 ; i++){//记得要走的步数是长度-k -1（head已经算走了一步了）  ;从末尾往前移动
            newTail = newTail.next;
        }

        //the new head will be newTail.next
        ListNode newHead = newTail.next;

        //break the circle ;
        newTail.next = null;

        return newHead;
    }
}
