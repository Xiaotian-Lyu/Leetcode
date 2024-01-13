package arraryandstring;

public class Q26 {
    public int removeDuplicates(int[] nums) {
        //two pointers
        int i = 0;//the not duplicate number

        //traversal the nums
        for(int j = 1; j < nums.length; j++){//没有"="
            //string.length()-方法
            //array.length-属性
            if(nums[j] != nums[i]){
                i++;//要写在第10行的前面，初始化i=0,index=0 已经比较过了 放在第一位
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
