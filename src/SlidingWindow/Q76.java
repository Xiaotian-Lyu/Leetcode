import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        //use hashmap: key-char / value-times
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        //add the t into the need
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //two pointers
        int left = 0, right = 0, minLength = s.length() + 1;
        int count = 0;//count the one same char
        int start = 0, end = 0;

        while(right < s.length()){
            //keep move the right pointer 
            char rc = s.charAt(right);
            right++;//不能忘记


            //check the value 
            if(need.containsKey(rc)){
                map.put(rc, map.getOrDefault(rc, 0) + 1);
                if(map.get(rc).equals(need.get(rc))){
                    //只能用equals比较Integer ：HashMap<Character, Integer>
                    //== 只能用基本数据类型 int double
                    count++;
                }
            }


            //if find all the character - check the length
            while(count == need.size()){//这里要多次比较 所以用while？t.length()会有重复的字符
                if(right - left < minLength){
                    minLength = right - left;//因为上面的right++了，所以这里的right = right + 1
                    start = left;
                    end = right;
                }

                //move the left
                char lc = s.charAt(left);
                left++;//不能忘记
                //remove the lc from map and count
                if(need.containsKey(lc)){
                    if(map.get(lc).equals(need.get(lc))){//只能用equals
                        count--;
                    }
                    map.put(lc, map.get(lc) - 1);
                }

            }
        }

        return s.substring(start, end);//这里的end = right + 1，取的是end - 1 = right
    }
}