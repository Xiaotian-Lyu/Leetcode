package twopointers;

import model.ListNode;

public class Q19 {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //1.dummy Node
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            //2.fast/slow pointer start from dummy
            ListNode fast = dummy;
            ListNode slow = dummy;

            //3.move the fast n steps
            for(int i = 0; i < n; i++){
                fast = fast.next;
            }

            //4.fast/slow pointer move together util fast reach the end
            //while(fast != null) 注意条件的判断。
            //当 fast != null 到最后一个还会进去循环 移动指针 到 null
            //当 fast.next != null 到最后第二个进去循环 移动到 最后一个
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }

            //5.delete the node
            slow.next = slow.next.next;

            //6.return the dummy.next
            return dummy.next;
        }
    }

}
