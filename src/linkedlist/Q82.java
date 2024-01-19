package linkedlist;

import model.ListNode;

public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        //fast slow pointers to delete
        ListNode dummy = new ListNode(), slow = dummy, fast = head; slow.next = fast;//不要忘记new!!!!!书写方式？？？

        while(fast != null){//traversal the list

            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }

            if(slow.next != fast){// we find the duplicate
                slow.next = fast.next;
                fast = slow.next;//update the fast
            }else{//not dup both go to the next step
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

}
