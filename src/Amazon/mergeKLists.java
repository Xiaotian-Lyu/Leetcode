package Amazon;

import model.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKLists {
    public ListNode mergeKLists(List<List<Integer>> lists) {
        // 1. 转换 List<List<Integer>> 为 ListNode 链表
        List<ListNode> nodeLists = new ArrayList<>();
        for (List<Integer> list : lists) {
            nodeLists.add(convertToListNode(list));
        }

        // 2. 使用优先队列（最小堆）合并链表
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : nodeLists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            if (node.next != null) pq.offer(node.next);
        }

        return dummy.next;
    }

    // 辅助方法: 把 List<Integer> 转换成 ListNode
    //当 给的是List<List<Integer>> lists 时候
    private ListNode convertToListNode(List<Integer> list) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : list) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

}
