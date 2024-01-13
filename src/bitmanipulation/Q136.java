package bitmanipulation;

public class Q136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;//和0异或是本身 ；本身和本身异或是0 ；
                        // 相同位相异是1，相同是0
                       //类比俄罗斯方块 相同就消掉
        }
        return res;
    }
}
