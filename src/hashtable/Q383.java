package hashtable;

public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[128];
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;//找到对应的哈希值，并加一
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            freq[ransomNote.charAt(i) - 'a']--;//找到对应的哈希值，并加一
            if (freq[ransomNote.charAt(i) - 'a'] < 0) {//小于0说明 对应的字母没有找到
                return false;
            }
        }
        return true;
    }
}
