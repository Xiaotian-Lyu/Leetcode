package linkedlist;

import model.ListNode;

public class Q21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode node1 = list1, node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
                cur = cur.next;
            }
        }
        if (node1 != null) {
            cur.next = node1;
        } else {
            cur.next = node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        mergeTwoLists(list1, list2);
    }
}
