package arraryandstring;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        //Initialize the result：the first string
        String res = strs[0];

        for (String str : strs) {//traversal each string
            //compare the result
            while (!str.startsWith(res)) {//不是 substart 注意大小写
                res = res.substring(0, res.length() - 1);//if not = res,res-1 ,the index from 0-
            }

        }
        return res;
    }
}
