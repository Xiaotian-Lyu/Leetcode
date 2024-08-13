import java.util.*;
public class LongestSubarray {
    public static int findLongestSubarray(int[] arr, int limit) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        // 计算每个元素的左边界
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        // 清空栈以计算右边界
        s.clear();
        // 计算每个元素的右边界
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        int maxLength = -1;

        // 计算最长的符合条件的子数组长度
        for (int i = 0; i < n; ++i) {
            int len = right[i] - left[i] - 1;
            long te = (long) arr[i] * (long) len;
            if (te > (long) limit) {
                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 1};
        int limit = 6;
        int result = findLongestSubarray(arr, limit);
        System.out.println(result);  // 应输出 3
    }
}
