package twopointers;

public class Q167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 1, j = numbers.length;

            while(i < j){
                int sum = numbers[i-1]+numbers[j-1];
                if(target == sum) return new int[]{i, j};
                if(target > sum){
                    i++;
                }else{
                    j--;
                }
                // if(target < sum){
                //     j--;
                // }
            }

            return new int[2];

        }
    }
}
