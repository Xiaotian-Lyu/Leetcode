package arrary;

import java.util.HashSet;
import java.util.Set;

public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();//不需要初始化长度？
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);//第一次出现的数字把它加入set里面
        }
        return false;
    }
}
