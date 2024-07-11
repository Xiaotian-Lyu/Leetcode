package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> hashset = new HashSet<>(wordDict);

            //index = letters numers
            int n = s.length();
            boolean[] f = new boolean[n + 1];

            //不能忘了初始化
            f[0] = true;

            for(int i = 1; i <= n; i++){
                for(int j = i - 1; j >=0; j--){//错误j++
                    if(f[j] && hashset.contains(s.substring(j, i))){
                        f[i] = true;
                        break;
                    }
                }
            }

            return f[n];
        }
    }

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

        class Solution3 {
            public boolean wordBreak(String s, List<String> wordDict) {
                boolean[] dp = new boolean[s.length() + 1];
                dp[0] = true;
                for (int i = 1; i <= s.length(); i++) {
                    for (String word : wordDict) {
                        if (i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
                return dp[s.length()];
            }
        }
    }
}
