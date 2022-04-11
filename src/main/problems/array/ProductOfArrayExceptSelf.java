import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    
    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * 
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * 
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * 
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     * 
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     * 
     * @param arr
     * @return
     */
    public static int[] returnProductOfArrayExceptSelf(int[] arr) {
        int[] befores = new int[arr.length];
        int[] afters = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            befores[i] = i == 0 ? arr[i] : befores[i - 1] * arr[i];
            afters[arr.length - 1 - i] = i == 0 ? arr[arr.length - 1] : afters[arr.length - 1 - i + 1] * arr[arr.length - 1 - i];
        }
        System.out.println("befores: " + Arrays.toString(befores));
        System.out.println("afters: " + Arrays.toString(afters));

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i ++) { 
            int before = i - 1 < 0 ? 1 : befores[i - 1];
            int after = i + 1 > arr.length - 1 ? 1 : afters[i + 1];
            result[i] = before * after;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,3,4};
        int[] test2 = {-1,1,0,-3,3};

        System.out.println("\t answer 1: " + Arrays.toString(returnProductOfArrayExceptSelf(test1)));
        System.out.println("\t answer 2: " + Arrays.toString(returnProductOfArrayExceptSelf(test2)));
    }    
}
