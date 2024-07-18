package arraryandstring;

import java.util.ArrayList;
import java.util.List;

public class Q438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();

            int[] pCount = new int[26];
            int[] sCount = new int[26];

            //get the p of each characters frequncy
            for(Character c : p.toCharArray()){ //错误character  Char
                //两种写法都可Character /char
                pCount[c - 'a']++;
            }

            int plength = p.length();
            int slength = s.length();

            //traversal the s with p, if the same
            for(int i = 0; i < slength; i++){
                sCount[s.charAt(i) - 'a']++;

                //sliding window
                if(i >= plength){
                    sCount[s.charAt(i - plength) - 'a']--;
                }

                //check the s and p
                if(isSame(pCount, sCount)){
                    result.add(i - plength + 1);
                }
            }
            return result;
        }

        public boolean isSame(int[] pCount, int[] sCount){
            for(int i = 0 ; i < 26; i++){
                if(pCount[i] != sCount[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
