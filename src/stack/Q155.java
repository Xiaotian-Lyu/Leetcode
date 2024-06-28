package stack;

public class Q155 {
    class MinStack2 {
        class Node{
            Node next;
            int min;
            int val;
            //constructer
            public Node(int val, int min, Node next){
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        //A head manupulate
        Node head; //声明了Node 但是没有新建 说明这个head == null

        public MinStack2() {
            //空参构造器 如果没有往里push 值。它的head 就是 null
        }

        public void push(int val) {
            //check the head first
            if(head == null){
                this.head = new Node(val, val, null);
            }else{
                //错误写法：this.head = new Node(val, Math.min(head.val, val), head);
                this.head = new Node(val, Math.min(head.min, val), head);
            }

        }

        public void pop() {
            this.head = head.next;

        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
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
