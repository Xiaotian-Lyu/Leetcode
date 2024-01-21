package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    private int capacity;
    private Map<Integer,Node> cache;// method-get
    private DoubleLinkedList order;// method-put

    public Q146(int capacity){//contructor
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new DoubleLinkedList();
    }

    public int get(int key){
        //determine if contains
        if(cache.containsKey(key)){
            Node node = cache.get(key); //错误写法：int value = cache.get(key);map 的value 是一个node
            order.moveToFront(node);    //不要忘了往前移动！！！！
            return node.value;//错误写法value
        }
        return -1;//don't exist
    }

    public void put(int key,int value){//错误写法：（Node node）这里的value 为什么不是node：需要先有key 去比较值
        //if cache contains the node or not
        if(cache.containsKey(key)){
            //update the value and move the node to the front
            Node node = cache.get(key);
            node.value = value;
            order.moveToFront(node);//错误写法 moveToFront(node)
        }else{
            //determine if meet the capacity
            if(cache.size() == capacity){
                //remove the least recent used
                Node removed = order.removeLast();//listnode 删除
                cache.remove(removed.key);//hashmap 删除
            }
            //add new node
            Node newNode = new Node(key,value);
            cache.put(key, newNode);//hashmap 添加
            order.addToFront(newNode);//listnode 添加
        }
    }

    private static class Node{
        int key;
        int value;
        Node pre;
        Node next;

        //constructor 为什么不用 public 因为已经是private
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }

    private static class DoubleLinkedList{
        //easy to insert and remove
        private Node head;
        private Node tail;

        //constructer
        DoubleLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.next = head;
        }

        void moveToFront(Node node){//equals :addToFront and remove 可以调换顺序吗:不可以 因为后删除会把所有的都删除
            remove(node);
            addToFront(node);
        }

        void addToFront(Node node){
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        void remove(Node node){
            //错误写法：head.next = node.next; tail.pre = head
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }

        Node removeLast(){//有返回值！！！！！
            Node lastNode = tail.pre;
            remove(lastNode);
            return lastNode;//为什么要return 要从hashmap 和 linkedlist 里面删除
        }
    }
}
