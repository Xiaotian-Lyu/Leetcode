package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int i = 0, j = 0, res = 0;
            while(j < s.length()){
                char rc = s.charAt(j);
                while(set.contains(rc)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(rc);
                res = Math.max(res,set.size());
                j++;
            }
            return res;
        }
    }
}
