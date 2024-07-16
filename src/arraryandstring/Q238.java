package arraryandstring;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        //result
        int n = nums.length;
        int[] result = new int[n];

        //calculate the left side
        int left = 1;
        for(int i = 0; i < n; i++){
            result[i] = left;//no left number at the first time
            left *= nums[i];
        }

        //calculate the right side
        int right = 1;
        for(int i = n -1; i >= 0; i--){
            result[i] *= right;//we have left product in the result so use *
            right *= nums[i];
        }

        return result;

    }
}

