package stack;

public class Q155 {
    class MinStack {

        class Node{
            Node next;
            int val;
            int min;

            public Node(Node next,int val,int min){
                this.next = next;
                this.val = val;
                this.min = min;
            }
        }

        Node head;

        public MinStack(){

        }

        public void push(int val){
            //this.head = new Node(null, val , val);
            if(head == null){
                this.head = new Node(null, val , val);
            }else{
                //XX： min(val,head.val)
                this.head = new Node(head, val, Math.min(val,head.min));
            }
        }

        public void pop(){
            head = head.next;
        }

        public int top(){
            return head.val;
        }

        public int getMin(){
            return head.min;
        }
    }
}
