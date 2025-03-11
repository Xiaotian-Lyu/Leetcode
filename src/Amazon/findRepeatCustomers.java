package Amazon;

import java.util.*;

public class findRepeatCustomers {
    /**
     * Given a file with logs, each log has timestamp and customer
     * find the repeat customer that visited the website in mutiple days
     * 非常简单的string process题目
     * 只需要用一个map去储存没见过的customer的timstamp，如果customer在map里面而且timestamp不一样就把customer加到output set里面就好
     * follow up是如果要customer在n及以上distinct day visited过的话要怎么去改代码
     * 只需要把map的value换成set就可以了
     * 最后follow up问time and space complexity
     *
     * log - String time, customer
     * output - set<customer><time>
     * output - customers >=n
     */
    public Set<String> customer(List<String> log){
        Set<String> res = new HashSet<>();
        Map<String,String> map = new HashMap<>();
        for(String s : log){
            String[] logC = s.split(" ");
            String customer = logC[0];
            String time = logC[1];

            if(map.containsKey(customer) && !map.get(customer).equals(time)){
                res.add(customer);
            }else{
                map.put(customer, time);
            }
        }
        return res;
    }

    public Set<String> customer2(List<String> log, int n){
        Set<String> res = new HashSet<>();
        Map<String,Set<String>> map = new HashMap<>();
        for(String s : log){
            String[] logC = s.split(" ");
            String customer = logC[0];
            String time = logC[1];

            map.putIfAbsent(customer, new HashSet<>());
            map.get(customer).add(time);
            if(map.get(customer).size() >= n){//customer在n及以上
                res.add(customer);
            }

            //distinct day visited(一天内重复登录算一次) - Map<String,Set<String>>

//            if(map.containsKey(customer) && !map.get(customer).equals(time)){
//                res.add(customer);
//            }else{
//                map.put(customer, time);
//            }
        }
        return res;
    }

    public Set<String> customer3(List<String> log, int n){
        Set<String> res = new HashSet<>();
        Map<String,Map<String, Set<String>>> map = new HashMap<>();
        for(String s : log){
            String[] logC = s.split(" ");
            String customer = logC[0];
            String day = logC[1];//day
            String time = logC[2];//time

            map.putIfAbsent(customer, new HashMap<>());//初始化外层！！！！！
            map.get(customer).putIfAbsent(day,new HashSet<>());//初始化内层！！！！！

            map.get(customer).get(day).add(time);
            if(map.get(customer).size() >= n){//这样是算几天登录过
                // distinct day visited(一天内重复登录算一次) - Map<String,Set<String>>
                //if(map.get(customer).get(day).size() >= n) 错误写法 这样是算一天内登录几次
                res.add(customer);
            }

        }
        return res;
    }

}
