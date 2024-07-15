package arraryandstring;

public class Q268 {
    public class Solution {
        public int missingNumber(int[] integers) {
            int n = integers.length;
            int expected_sum = n * (n + 1) / 2;
            int actual_sum = 0;

            for (int i = 0; i < n; i++) {
                actual_sum += integers[i];
            }

            return expected_sum - actual_sum;
        }
    }

}
