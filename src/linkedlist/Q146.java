package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        int capacity;
        HashMap<Integer, Node> map;
        DoubleLinkedList list;//❌DoubleLinkedList<Node> list;

        LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new DoubleLinkedList();//❌new DoubleLinkedList<>();
        }

        class Node {
            int key;
            int value;
            Node next;
            Node pre;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
                this.pre = null;
            }
        }

        public int get(int key) {
            //if have the key
            if (map.containsKey(key)) {
                Node cur = map.get(key);
                list.removeToFront(cur);
                return cur.value;
            }
            return -1;

        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                //update value
                Node cur = map.get(key);
                cur.value = value;//这里改的是list 和 map 里面的value？
                /**
                 Yes, modifying cur.value in the put method updates the value in both the map
                 and the list. This is because the cur node object is stored in both the map and
                 the list. Since objects in Java are referenced by reference, any changes made to the node object through
                 one reference (in the map) are reflected in the same object referenced elsewhere (in the list).
                 */
                list.removeToFront(cur);
            } else {
                //check capacity 错误写法if(LRUCache.capacity > )
                if (capacity == map.size()) {//只要判断 是否相等就是 相等就是满了 不想等就是没满
                    Node remove = list.removeLast(); //map 也要删除
                    map.remove(remove.key);
                }
                //add the new node
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                list.addTofront(newNode);
            }

        }

        class DoubleLinkedList {
            Node head;
            Node tail;

            //构造器不能忘
            DoubleLinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.pre = head;
            }

            void removeToFront(Node node) {
                remove(node);
                addTofront(node);
            }

            void remove(Node node) {
                Node pre = node.pre;
                Node next = node.next;
                pre.next = next;
                next.pre = pre;
            }

            Node removeLast() {
                Node pre = tail.pre;
                remove(pre);
                return pre;
            }

            void addTofront(Node node){
                //报错的原因大多是因为 在加node 的时候 next点的丢失
                //可以直接拿个值保存next 再修改指针
                Node next = head.next;
                head.next = node;
                node.pre = head;
                node.next = next;
                next.pre = node;
            }

        }


    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */


    private int capacity;
    private Map<Integer, Node> cache;// method-get
    private DoubleLinkedList order;// method-put

    public Q146(int capacity) {//contructor
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new DoubleLinkedList();
    }

    public int get(int key) {
        //determine if contains
        if (cache.containsKey(key)) {
            Node node = cache.get(key); //错误写法：int value = cache.get(key);map 的value 是一个node
            order.moveToFront(node);    //不要忘了往前移动！！！！
            return node.value;//错误写法value
        }
        return -1;//don't exist
    }

    public void put(int key, int value) {//错误写法：（Node node）这里的value 为什么不是node：需要先有key 去比较值
        //if cache contains the node or not
        if (cache.containsKey(key)) {
            //update the value and move the node to the front
            Node node = cache.get(key);
            node.value = value;
            order.moveToFront(node);//错误写法 moveToFront(node)
        } else {
            //determine if meet the capacity
            if (cache.size() == capacity) {
                //remove the least recent used
                Node removed = order.removeLast();//listnode 删除
                cache.remove(removed.key);//hashmap 删除
            }
            //add new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);//hashmap 添加
            order.addToFront(newNode);//listnode 添加
        }
    }

    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        //constructor 为什么不用 public 因为已经是private
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private static class DoubleLinkedList {
        //easy to insert and remove
        private Node head;
        private Node tail;

        //constructer
        DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.next = head;
        }

        void moveToFront(Node node) {//equals :addToFront and remove 可以调换顺序吗:不可以 因为后删除会把所有的都删除
            remove(node);
            addToFront(node);
        }

        void addToFront(Node node) {
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        void remove(Node node) {
            //错误写法：head.next = node.next; tail.pre = head
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }

        Node removeLast() {//有返回值！！！！！
            Node lastNode = tail.pre;
            remove(lastNode);
            return lastNode;//为什么要return 要从hashmap 和 linkedlist 里面删除
        }
    }
}
