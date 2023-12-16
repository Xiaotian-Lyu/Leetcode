package string;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';//get the index of each letter
            countS[index]++;//count the index
        }
        int[] countT = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';//get the index of each letter
            countT[index]++;//count the index
        }
        for (int i = 0; i < 26; i++) {
            if (countT[i] != countS[i]) return false;
        }
        return true;
    }
}
