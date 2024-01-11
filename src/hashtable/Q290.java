package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q290 {
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
                //可以用equals 代替 但是要先排除 是null 的情况
                return false;
            }
            mapForPattern.put(c, i);
            mapForStr.put(w, i);

        }
        return true;
    }
}
