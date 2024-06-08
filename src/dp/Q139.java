package dp;

import java.util.HashSet;
import java.util.List;

public class Q139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            //i 不是index 而是 包含字母
            //i 的最长长度= s,length()
            for (int i = 1; i <= s.length(); i++) {
                for (String word : wordDict) {
                    //首先要满足i>= word.length(),比拆分单词小少的必不可能
                    //dp[i] == true 的前提是 dp[i- 拆分单词]是true
                    //拆分单词 = s在这一轮的 substring[a,b)
                    if (i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];//默认是false 但是遍历到那一层了符合条件会改成true
        }

        class Solution2 {
            public boolean wordBreak(String s, List<String> wordDict) {
                HashSet<String> set = new HashSet<>(wordDict);
                boolean[] valid = new boolean[s.length() + 1];
                valid[0] = true;

                for (int i = 1; i <= s.length(); i++) {
                    for (int j = 0; j < i && !valid[i]; j++) {
                        if (set.contains(s.substring(j, i)) && valid[j]) {
                            valid[i] = true;
                        }
                    }
                }

                return valid[s.length()];
            }
        }
    }
}
