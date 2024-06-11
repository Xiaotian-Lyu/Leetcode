package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Q290 {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            Map<Character, String> map = new HashMap<>();

            String[] words = str.split(" ");

            //错误：if(pattern.length() != str.length()) return false;
            if(pattern.length() != words.length) return false;


            for(int i = 0 ;i < pattern.length(); i++){
                Character c = pattern.charAt(i);
                String w = words[i];

                if(map.containsKey(c)){
                    //错误 if(map.get(keyP) != valueS){
                    if(!map.get(c).equals(w)){
                        return false;
                    }
                }else{
                    if(map.containsValue(w)){
                        return false;//match with other key
                    }
                    map.put(c,w);
                }
            }
            return true;

        }
    }
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");//use black to split each words of str
        //judge the length to exclude
        if (pattern.length() != words.length) return false;
        //words.length是数组的属性
        //pattern.length() 是字符串的方法

        //create a hashmap to store the mapping relationship
        Map<Character, Integer> mapForPattern = new HashMap<>();
        Map<String, Integer> mapForStr = new HashMap<>();

        //traversal the pattern to check each index
        //integer i not int "==" or "!=" only works for Integer whos value is below 127.
        for (Integer i = 0; i < words.length; i++) {   //pattern.length()也行
            char c = pattern.charAt(i);
            String w = words[i];
            if (mapForPattern.get(c) != mapForStr.get(w)) {
                //可以用equals 代替 但是要先排除 是null 的情况 先看一下是否contains，再比较value是否相等
                return false;
            }
            mapForPattern.put(c, i);
            mapForStr.put(w, i);

        }
        return true;
    }
}
