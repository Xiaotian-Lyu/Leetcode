package test;

public class Q13 {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += res >= 5 ? -1 : 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += res >= 50 ? -10 : 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += res >= 500 ? -100 : 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q13 q13 = new Q13();
        System.out.println(q13.romanToInt("III"));  // 输出应为3
        System.out.println(q13.romanToInt("IV"));  // 输出应为4
        System.out.println(q13.romanToInt("IX"));  // 输出应为9
        System.out.println(q13.romanToInt("LVIII"));  // 输出应为58
        System.out.println(q13.romanToInt("MCMXCIV"));  // 输出应为1994
    }
}


