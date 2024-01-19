package linkedlist;

import model.ListNode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;//cur 是指针需要不断更新？
        int carry = 0;

        //traversal the l1 and l2
        while(l1 != null || l2 != null || carry != 0){//l1.val !== null 不是判断值而是判断是不是空
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            cur.next = new ListNode(sum % 10);//get the remainder 需要新建list Node!!
            carry = sum/10;//get the digit in the tens place
            cur = cur.next;//不要忘了这一步！！

            l1 = l1 == null ? null : l1.next;//update the l1 错误写法l1.val == null ? 0 : l1 = l1.next
            l2 = l2 == null ? null : l2.next;//update the l2
        }

        return dummy.next;//cur.next为什么不行： cur 指针一直在移动，而 dummy 节点是创建用于保持头部的，没有移动。
    }
}
