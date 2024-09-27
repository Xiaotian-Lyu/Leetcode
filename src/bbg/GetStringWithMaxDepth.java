package bbg;

import java.util.*;

public class GetStringWithMaxDepth {
    static List<String> getStrings(String s) {
        //1.hashmap: key - depth ; value - List<String>
        Map<Integer, List<String>> map = new HashMap<>();

        //2.stringBuilder to builder the same layer string
        StringBuilder builder = new StringBuilder();
        int depth = 0, maxDepth = 0;

        //3.traversal the string - meet left => last layer ; right this layer
        for(char c : s.toCharArray()){
            if(c == '(' || c == '['|| c == '{'){
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }else if (c == ')' || c == ']'|| c == '}'){
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                depth--;
            }else{
                builder.append(c);
            }
        }

        return map.get(maxDepth);
    }

    public static void main(String[] args) {
        System.out.println(getStrings("abc(def)ghi"));
        System.out.println(getStrings("abc(def[ghi]jkl)mno"));
        System.out.println(getStrings("abc(def[ghi]jkl)mno{vfr}"));
        System.out.println(getStrings("abc(def)ghi[jkl]mno"));
        System.out.println(getStrings("abc(def[ghi]jkl)mno"));
    }
}
