package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Q133 {
    //hashmap <oldNode , newNode >
    //错误写法：Hashmap<Node,Node> map = new Hashmap<>();
    HashMap<Node, Node> map = new HashMap<>();

    //DFS
    public Node cloneGraph(Node node) {
        //check if it null
        if (node == null) return null;

        return helper(node);
    }


    //递归调用：代码使用递归方法helper来实现节点的克隆。
    //每次调用helper时，都会先克隆当前节点，然后递归克隆其所有邻居节点。
    //这种递归方式本质上就是深度优先搜索。
    private Node helper(Node node) {

        //check if it copy already return the new node
        if (map.containsKey(node)) return map.get(node);

        //new node and put into the map
        //public Node(int _val, ArrayList<Node> _neighbors)
        Node newNode = new Node(node.val, new ArrayList<Node>());

        //错误写法 map.put(newNode);
        map.put(node, newNode);

        //traversal each neighbors
        for (Node neighbor : node.neighbors) {
            //错误写法：helper(neighbor);
            //newNode.neighbors => list.add(oldNode.neighbor)
            newNode.neighbors.add(helper(neighbor));
        }

        return newNode;
    }


}
