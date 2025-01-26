package Google;

import java.util.*;

public class duplicateNumber {
    //长度为n的数组array，其中每个元素x满足0≤x≤n-1。// 找到数组中所有重复的元素。
    //用hashmap遍历，时间复杂度0(n)，空间复杂度0(n)
    // follow up;不使用extra space
    // not rescursive call or func call
    public int[] repeatNumber(int[] nums){
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        for (int value : map.values()){
//            if(value > 1){
//                list.add(value);//错误这里要添加的是key 不是value
//            }
//        }
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                list.add(key);
            }
        }

        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public List<Integer> repeatNumber2(int[] nums){
        List<Integer> res = new ArrayList<>();
        //{3, 1, 2, 4, 0, 1};
        //{4, 1, 2, 3, 0, 1};  {0, 1, 2, 3, 4, 1};
//        for(int i = 0; i < nums.length;  i++){
//            while(nums[i] != i){
//                int index = nums[i];//3
//                int temp = nums[index];//4
//                nums[index] = index;
//                nums[i] = temp;
//            }
//        }
//        for(int i = 0; i < nums.length;  i++){
//            if(nums[i] != i){
//                res.add(nums[i]);
//            }
//        }
//        return res;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i){//if 的话只能交换一次 而我们需要一直交换直到到达正确位置
                //need to change palace
                //{3, 1, 2, 3, 0};
                int value = nums[i];//0
                if(value == nums[value]){
                    break;//already in the right place
                }
                int temp = nums[value];//store 3
                nums[value] = value;//swap 0 to index 0
                nums[i] = temp;
            }
        }

//        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]){
//                res.add(i);//最后加入的是value 不是index
                res.add(nums[i]);
            }
        }

        return res;
    }

    public List<Integer> repeatNumber3(int[] nums){
        List<Integer> res = new ArrayList<>();
        //{1, 3, 0, 1};  change 0 -> 1000
        int countZ = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = 1000;// 0 -> 1000
                countZ++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(index == 1000) continue;
            if(nums[index] < 0){
                res.add(index);
            }else {
                nums[index] *= -1;
            }
        }

        if(countZ > 1){
            res.add(0);
        }

        return res;
    }



    public static void main(String[] args) {
        duplicateNumber test = new duplicateNumber();
        int[] array1 = {3, 1, 2, 3, 0};
        int[] array2 = {1, 3, 0, 1};//{3, 1, 0, 1}; {0, 1, 1, 3};
        int[] array3 = {1, 3, 0, 1};
        int[] array4 = {1, 3, 0, 1};
        System.out.println(Arrays.toString(test.repeatNumber(array2)));//array 没有重写toString方法
        System.out.println(test.repeatNumber2(array3));//这里举例子的时候 每个都需要新建
        System.out.println(test.repeatNumber3(array4));//这里举例子的时候 每个都需要新建
    }

}
