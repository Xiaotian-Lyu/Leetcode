package Google;

import java.util.HashMap;
import java.util.Map;

public class FindMaximumFrequencyofNumberSolution {
    /*
    Given a sorted array, find the maximum frequency of a number.
    Example: [1,2,2,3,3,3,3,4,4,5,6] : Answer: 4 (3 is repeated 4 times).
    O(N) is a straightforward solution. Asked if the performance can be improved.
    Input:  nums = [1,2,2,3,3,3,3,4,4,5,6]
    Output: 4
     */

    //方法一：hashmap
    public int findMaximumFrequency1(int[] nums) {
        // write your code here
         Map<Integer, Integer> map = new HashMap<>();//space On
         int res = 0;
         for(int n : nums){
           map.put(n, map.getOrDefault(n, 0) + 1);
           res = Math.max(res, map.get(n));//there for one loop
         }

//         for(int times : map.values()){
//           //map.values() return  Collection<V>
//           res = Math.max(res, times);
//         }

        return res;
    }

    public int findMaximumFrequency2(int[] nums){
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            int length = 1;
            while(i > 0 && i < nums.length && nums[i] == nums[i - 1]){
                length++;
                i++;//在这里就更新i
//                res = Math.max(res, length);//这个可以写在while 里面外面都可以 就是滑动窗口
            }
            res = Math.max(res, length);//有可能没办法进while循环
        }
        return res;
    }

    public int findMaximumFrequency3(int[] nums){
        int res = 0;
        int left = 0;
        int fre = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] != nums[left]){//not same number - left
                fre--;
                left++;
            }
            fre++;
            res = Math.max(res, fre);
        }
        return res;
    }

    public int findMaximumFrequency4(int[] nums){
        int res = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] != nums[left]){//not same number - left //3和4 时间复杂度都是n 但感觉这个效率更高
                //用while是逐步减小窗口 用if 直接更新起始点
                left = right;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args){
        FindMaximumFrequencyofNumberSolution test1 = new FindMaximumFrequencyofNumberSolution();
        int[] n1 = new int[]{1,2,2,3,3,3,3,4,4,5,6};
        int[] n2 = {1, 1, 1, 2, 3, 4, 5};
        int[] n3 = {1, 2, 3, 4, 5};
        System.out.println(test1.findMaximumFrequency1(n1));
        System.out.println(test1.findMaximumFrequency1(n2));
        System.out.println(test1.findMaximumFrequency1(n3));

        System.out.println(test1.findMaximumFrequency2(n1));
        System.out.println(test1.findMaximumFrequency2(n2));
        System.out.println(test1.findMaximumFrequency2(n3));

        System.out.println(test1.findMaximumFrequency3(n1));
        System.out.println(test1.findMaximumFrequency3(n2));
        System.out.println(test1.findMaximumFrequency3(n3));

        System.out.println(test1.findMaximumFrequency4(n1));
        System.out.println(test1.findMaximumFrequency4(n2));
        System.out.println(test1.findMaximumFrequency4(n3));
    }

}
