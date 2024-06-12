package twopointers;

public class Q189 {
    class Solution1 {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverceArray(nums, 0 , nums.length -1);
            reverceArray(nums, 0 , k - 1);
            reverceArray(nums, k , nums.length -1);
        }
        private void reverceArray(int[] nums, int i,int j){
            while(j > i){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }


    }

    public class Solution2 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n; // 处理 k 大于数组长度的情况
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                result[(i + k) % n] = nums[i];
            }

            // 将结果数组复制回原数组
            for (int i = 0; i < n; i++) {
                nums[i] = result[i];
            }
        }
    }

    public class Solution3 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = 0; // 记录已经移动的元素个数

            for (int start = 0; count < n; start++) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                } while (start != current);
            }
        }
    }


}
