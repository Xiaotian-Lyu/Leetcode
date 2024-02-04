package binarytree;

public class Q117 {
    public Node connect(Node root) {
        Node dummyHead = new Node(0);// point to the first element in the current laywer
        Node pre = dummyHead;// point to the node - to build the next pointers
        Node realRoot = root;//to return the statement

        while(root != null){
            if(root.left != null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;

            if(root == null){//reach the last in the current layer
                pre = dummyHead;//reset the pre
                root = dummyHead.next;//root come to the next layer
                dummyHead.next = null;//need to point to null otherwise it will always in the while loop--be in the last laywer
            }
        }
        return realRoot;
    }
}
