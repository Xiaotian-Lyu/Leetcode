package stack;

import java.util.LinkedList;
import java.util.List;

public class Q71 {
    class Solution {
        public String simplifyPath(String path) {
            //1 - split "/"
            //XXXX: str[] str = path.split("/");
            String[] strs = path.split("/");
            //错误写法List<String> list = new LinkedList<>();左边是声明看； 右边是实现
            LinkedList<String> list = new LinkedList<>();


            /**
             2.check the contxt
             "" "." :continue
             ".." : a-biginner/not
             else: keep
             */
            /**
             错误写法
             for(String s: strs){
             if(s == " " || s == ".") continue;
             if(s == ".."){
             if(!list.isEmpty()){
             list.removeLast();
             }else{
             list.addLast(s);
             }
             }else{
             list.addLast();
             }
             }
             */
            for(String s: strs){
                if(s.equals("") || s.equals(".") ) continue;
                if(s.equals("..")){
                    if(!list.isEmpty()){
                        list.removeLast();//list 要remove 需要传元素
                    }
                }else{
                    list.addLast(s);
                }
            }

            //3.stringbulider to return
            StringBuilder s = new StringBuilder();
            if(list.isEmpty()) return "/";
            //if(!list.isEmpty())只能判断一次
            while(!list.isEmpty()){
                s.append("/").append(list.removeFirst());//不用stack的原因：不能removeFirst
            }

            return s.toString();//StringBuilder 不是String
        }
    }
}
