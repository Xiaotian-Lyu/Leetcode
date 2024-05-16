package hashmap;

import java.util.*;

public class Q49 {
    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            //HashMap: key-String pattern, value-all situation
            Map<String, List<String>> map = new HashMap<>();

            //traversal strs
            for(String str : strs){
                int[] hash = new int[26];
                for(char c : str.toCharArray()){
                    hash[c - 'a']++;
                }
                //错误写法：String pattern = Array.toString(hash);
                String pattern = Arrays.toString(hash);

                //put into map
                //错误写法：map.putIfAbsent(pattern, new LinkedList<>());？？
                map.putIfAbsent(pattern, new ArrayList<>());
                map.get(pattern).add(str);
            }
            //return the map-value 错误写法：return map.value();
            return new ArrayList<>(map.values());

            /**
             O(n∗m)
             n is the number of strings in the input array.
             m is the maximum length of a string in the input array.
             */
        }
    }
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String pattern = Arrays.toString(chars);
                map.putIfAbsent(pattern, new ArrayList<>());
                map.get(pattern).add(str);
            }
            return new ArrayList<>(map.values());
        }
        /**
         O(n * m * log m)
         n is the number of strings in the input array.
         m is the maximum length of a string in the input array.
         log m - time of sort
         */

    }
}
