package linkedlist;
import model.ListNode;
import model.ListNode141;

import javax.swing.text.FlowView;


public class Q141 {
    public boolean hasCycle(ListNode head){
        if(head == null ){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}
