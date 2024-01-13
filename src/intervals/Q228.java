package intervals;

import java.util.ArrayList;
import java.util.List;

public class Q228 {

    public List<String> summaryRanges(int[] nums) {
        //new a list to store answer
        List<String> list = new ArrayList<>();//错误写法List<string> str = new arrrayList();
        //和arraylist的区别. arraylist是子类
        int startIndex = 0;

        //traversal the list
        for (int i = 0; i < nums.length; i++) {
            startIndex = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            //有两种可能：1-一个数字 2-两个数字(一个区间)
            if (startIndex == i) {//只有一个数字
                list.add(String.format("%d", nums[i]));//list = ? list.add 没有返回值
            } else {//是一个区间
                list.add(String.format("%d->%d", nums[startIndex], nums[i]));
            }
        }
        return list;

    }
}
