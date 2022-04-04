import java.util.Arrays;

public class CountingBits {
    
    /**
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     * 
     * @param n
     * @return
     * 
     * Ex. 1
     * Input: n = 2
     * Output: [0,1,1]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 
     * Ex. 1
     * Input: n = 5
     * Output: [0,1,1,2,1,2]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */
    public static int[] returnArraysOfBitCounts(int n) {
        int[] results = new int[n + 1];
        
        for (int i = 0; i<= n; i++){
            results[i] = NumberOfOneBits.returnNumberOfOneBits(i);
        }

        return results;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnArraysOfBitCounts(2)));
        System.out.println(Arrays.toString(returnArraysOfBitCounts(5)));
    }
}
