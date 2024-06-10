package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        //create two arrays to store letters
        int[] map1 = new int[256];//s
        int[] map2 = new int[256];//t

        if(s.length() != t.length()) return false;
        //traversal the length of s, to check if correspond to t
        for(int i = 0;i < s.length();i++){
            if(map1[s.charAt(i)] != map2[t.charAt(i)] ){
                return false;
            }
            //if two arrays[index] equal each other there are two situation
            // 1. equals 0 ——> not assigned, so we assigned next one
            // 2. equals with each other ?
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;

    }
    //hashmap 方法
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false; // If lengths are not equal, they cannot be isomorphic
            }

            Map<Character, Integer> mapS = new HashMap<>();
            Map<Character, Integer> mapT = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);

                // If the current characters don't match the previously recorded indices, return false
                if (!mapS.getOrDefault(charS, -1).equals(mapT.getOrDefault(charT, -1))) {
                    return false;
                }

                // Record the current index (+1 to avoid conflict with default value)
                mapS.put(charS, i + 1);
                mapT.put(charT, i + 1);
            }
            return true;
        }
    }

}
