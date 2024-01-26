package linkedlist;

import model.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        //find the mid node of the linked list
        ListNode fast = head,slow = head;//错误写法——用分号
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //at the end slow will be the mid node;

        slow = reverse(slow);//reverse the linked list
        while(slow != null){
            if(slow.val != head.val) return false;//错误写法if(slow.val != fast.val)
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null,cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
