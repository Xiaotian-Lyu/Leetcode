package linkedlist;

import model.ListNode;

import java.util.PriorityQueue;

public class Q23 {
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
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
            //add all list head into minheap
            for(ListNode listHead : lists){
                //先要判断一下非空
                if(listHead != null){
                    minHeap.add(listHead);
                }

            }

            //create a new list
            ListNode dummy = new ListNode();
            ListNode cur = dummy;

            while(!minHeap.isEmpty()){
                //pull the smallest node
                ListNode smallest = minHeap.poll();
                cur.next = smallest;
                cur = cur.next;

                if(smallest.next != null){
                    minHeap.add(smallest.next);
                }
            }

            return dummy.next;

        }
    }
}
