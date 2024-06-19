package linkedlist;
import model.ListNode;


public class Q141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null) return false;
            ListNode fast = head, slow = head;

            while(fast != null && fast.next != null){//保证fast 可以走两步
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow)return true;
                // }else{ 不能直接else 还要进行 下一个循环
                //     return false;
                // }
            }

            return false;

        }
    }


}
