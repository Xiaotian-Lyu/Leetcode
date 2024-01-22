package linkedlist;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //copy the value: hashmap
        if (head == null) return head;

        Map<Node, Node> hashmap = new HashMap<>();
        Node cur = head;
        while (cur != null) {//错误写法判断head = null
            hashmap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //copy the next and random
        cur = head;
        while (cur != null) {
            hashmap.get(cur).next = hashmap.get(cur.next);//从hashmap 里去get key=cur 的node ；把它的指针指向 map里面 key= cur.next 的node
            hashmap.get(cur).random = hashmap.get(cur.random);
            cur = cur.next;
        }

        return hashmap.get(head);//不是return head-它是原始的头节点
    }
}
