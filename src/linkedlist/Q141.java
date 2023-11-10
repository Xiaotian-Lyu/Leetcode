package linkedlist;
import model.ListNode;
import model.ListNode141;


public class Q141 {
    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode fast = head, slow =head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

}
