package linkedlist;

import model.ListNode;

public class Q328 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode oddHead = head;
            ListNode evenHead = head.next;
            ListNode midHead = evenHead;

            while(evenHead != null && evenHead.next != null){
                oddHead.next = oddHead.next.next;
                evenHead.next = evenHead.next.next;
                oddHead = oddHead.next;
                evenHead = evenHead.next;
            }

            oddHead.next = midHead;
            return head;

        }
    }
}
