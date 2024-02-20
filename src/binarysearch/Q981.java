package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981 {
    //map<String,new Node(value,timestamp)> only one timestamp
    //map<String,[Node]>  binary search the [Node] find the vale <= timestaps
    class Node {
        String value;
        int timestamp;

        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    //create a map
    //错误写法：Map<String,Node>.   Map<String,List(Node)>
    Map<String, List<Node>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        //the key is not exist. new one putIfAbsent
        //错误写法：map.putIfAbsent(key,new Node(value,timestamp));
        map.putIfAbsent(key, new ArrayList<>());

        //if already exist
        map.get(key).add(new Node(value, timestamp));
    }


    public String get(String key, int timestamp) {
        //if not exist key return ""
        if (!map.containsKey(key)) return "";

        int left = 0;
        //错误写法：List list = map.get(key);
        //错误写法：int right = list.length; List 接口没有直接提供 length 方法，而是使用 size()
        //数组 new int[]（Array）具有 length 属性;数组的大小固定不能增加所以这里用list
        List<Node> list = map.get(key);
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else if (list.get(mid).timestamp > timestamp) {
                right = mid;
            }
        }

        if (left == 0) return "";//不用check 右边的值 因为值到达右边边界 就会返回右边-1的值
        return list.get(left - 1).value;

    }
}
