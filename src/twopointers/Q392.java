package twopointers;

public class Q392 {
    //更好理解
    public boolean isSubsequence1(String s, String t) {
        int indexS = 0;
        int indexT = 0;

        while(indexS < s.length() && indexT < t.length()){
            if(s.charAt(indexS) == t.charAt(indexT)){
                indexS++;
            }
            indexT++;
        }

        return indexS == s.length();//循环结束长度等于s.length -1 但是 后面 ++

    }


    //更快一丢丢的
    public boolean isSubsequence2(String s, String t) {

        int j = 0;//first point in t[0]
        //traversal the s//for(char ch:s)
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);//这句话写在这里会比写在第13行去比较更快
            while (j <= t.length()) {
                if (j == t.length()) return false;//can not find the letter
                if (ch == t.charAt(j)) {
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }
        return true;
    }


}
