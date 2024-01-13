package arraryandstring;

public class Q28 {
    public int strStr(String haystack, String needle) {
        //startIndex 必须要等于 indexOfHay
        //如果等于 indexOfNeed 会导致太短（needle的长度较短）
        for (int startIndex = 0; startIndex < haystack.length(); startIndex++) {
            int indexOfNeed = 0;
            int indexOfHay = startIndex;//需要把这个返回 所以 要保存一下
            while (indexOfHay < haystack.length() && indexOfNeed < needle.length()) {
                if (haystack.charAt(indexOfHay) != needle.charAt(indexOfNeed)) {
                    break;
                }
                indexOfNeed++;
                indexOfHay++;
            }
            if (indexOfNeed == needle.length()) {//本来是needle-1,但是当while循环结束的时候是                                                 needle-1,下一步操作的时候 ++了 所以 == needle
                return startIndex;
            }
        }
        return -1;
    }
}
