package Google;

public class GoldenArray {
    public boolean canFormPairAndTriplets(int[] nums) {
        // 假设数字范围是 1-100
        int[] freq = new int[101]; // 数组替代 Map

        // 统计频率
        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 0; i < 101; i++){
            if(freq[i] >= 2){
                //can be pair
                //copy this array and check the remaining if can be triplets
                int[] remaining = new int[101];
                System.arraycopy(freq, 0, remaining, 0, 101);//如果用hashmap的话就用一个for循环
                /*
                Map<Integer, Integer> copy = new HashMap<>();
                for(int i = 0; i < 101; i++){
                    copy.put(i, map.get(i));
                }
                */
                remaining[i] -= 2;//update

                if( canBeTriplets(remaining)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canBeTriplets(int[] remaining){
        //check if can be Triplets
        int count = 0;

        for(int i = 0; i < 101; i++){
            // find all 3 same number
            while(remaining[i] >= 3){
                remaining[i] -= 3;
                count++;
            }
            while(remaining[i] > 0){
                if(i + 2 < 101 && remaining[i] > 0 && remaining[i + 1] > 0 && remaining[i + 2] > 0){
                    remaining[i]--;
                    remaining[i + 1]--;
                    remaining[i + 2]--;
                    count++;
                }else{
                    return false;
                }
            }
        }
        return count > 1;
    }

    public static void main(String[] args) {
        int[] nums2 = {2, 2, 2, 3, 4, 5, 6, 6};
        GoldenArray test1 = new GoldenArray();
        System.out.println(test1.canFormPairAndTriplets(nums2));

        int[] nums3 = {2, 2, 2, 3, 4};
        GoldenArray test3 = new GoldenArray();
        System.out.println(test3.canFormPairAndTriplets(nums3));

        int[] nums4 = {4, 4, 4, 4, 4 , 4, 4, 4};
        GoldenArray test4 = new GoldenArray();
        System.out.println(test4.canFormPairAndTriplets(nums4));
    }
}
