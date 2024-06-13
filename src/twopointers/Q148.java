package twopointers;

import model.ListNode;

public class Q148 {
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
        public ListNode sortList(ListNode head) {
            //split and merge
            //1.find the mid of the list -> recursion
            if(head == null || head.next == null) return head;//exit of the recursion

            //2.split to two list -> two pointers
            ListNode fast = head, slow = head, mid = new ListNode();
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                mid = slow;
                slow = slow.next;
            }
            mid.next = null;

            ListNode l1 = sortList(head);//recursion
            ListNode l2 = sortList(slow);//recursion

            //3.merge and sort the two list
            return merge(l1,l2);
        }

        private ListNode merge(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            //ListNode l1, ListNode l2 -> none null
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            //when l1 or l2 is null
            if(l1 != null){
                cur.next = l1;
            }else{
                cur.next = l2;
            }
            return dummy.next;
        }
    }
}
