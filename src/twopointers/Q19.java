package twopointers;

import model.ListNode;

public class Q19 {

    class Solution3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode fast = dummy, slow = dummy;

            for(int i = 0; i < n ; i++){
                fast = fast.next;
            }

            while(fast.next != null){//stop when fast.next == null
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;//delete the nth form the end.
            //错误写法：slow.next = fast;
            /**
             slow.next = fast 的作用是将 slow 的下一个节点直接指向 fast 指针当前所在的位置。
             在这个上下文中，fast 最终会指向链表的最后一个节点，
             这意味着 slow.next 将被指向链表的最后一个节点，而不是正确删除目标节点。
             */

            return dummy.next;

        }
    }
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
