package linkedlist;

import model.ListNode;

import java.awt.print.Printable;

public class Q21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode n1 = list1;
        ListNode n2 = list2;
        while (n1 != null && n2 != null) {
            if(n1.val > n2.val){
                cur.next = n2;
                n2 = n2.next;
            }else {
                cur.next = n1;
                n1 = n1.next;
            }
            cur = cur.next;
        }
        if(n1 != null){
            cur.next = n1;
        }else {
            cur.next = n2;
        }
        return dummy;

    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = mergeTwoLists(list1, list2);

    }
}
