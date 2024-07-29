package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    class Solution {
        public String minWindow(String s, String t) {
            // 记录窗口中的字符出现次数
            Map<Character, Integer> map = new HashMap<>();
            // 需要的字符出现的次数
            Map<Character, Integer> need = new HashMap<>();
            // 统计t中的字符数量
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);//存在c- 拿到value + 1；不存在c - 默认是0 开始 +1
            }
            // left是左指针，right是右指针，minLen表示当前找到的最小窗口大小，count表示窗口中满足的字符数量
            int left = 0, right = 0, minLen = s.length() + 1, count = 0;//minlen 来记录最小长度：初始值 设定不可能的一个最大值
            // start和end是结果字符串的开头/结尾index-双指针
            int start = 0, end = 0;
            while (right < s.length()) {
                // rc 是将移入窗口的字符
                char rc = s.charAt(right);
                // 增大窗口
                right++;
                // 窗口内数据的更新
                if (need.containsKey(rc)) {
                    map.put(rc, map.getOrDefault(rc, 0) + 1);
                    // 当窗口中的当前字符出现的次数和需要的数量一致时，我们找到了一个满足条件的字符
                    if (map.get(rc).equals(need.get(rc))) {
                        count++;
                    }
                }
                // 满足条件后，尝试缩小窗口
                while (count == need.size()) {
                    // 更新最小长度和结果index
                    if (right - left < minLen) {
                        minLen = right - left;
                        start = left;
                        end = right;
                    }
                    // lc是要移除的字符
                    char lc = s.charAt(left);
                    // 缩小窗口
                    left++;
                    // 窗口内数据的更新
                    if (need.containsKey(lc)) {
                        // 只有在次数相同的时候，表示我们失去了一个满足条件的字符
                        if (map.get(lc).equals(need.get(lc))) {
                            count--;
                        }
                        map.put(lc, map.get(lc) - 1);
                    }
                }
            }
            return s.substring(start, end);
        }
    }
}
