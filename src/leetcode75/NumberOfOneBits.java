public class NumberOfOneBits {
  
    /**
     * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
     * 
     * Note:
     *      - Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
     *      - In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
     * @param a
     * @return
     */
    public static int returnNumberOfOneBits(int a) {
        int numBits = 0;

        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((a & mask) != 0) numBits++;
            mask = mask << 1;
        }

        return numBits;
    }
    
    public static void main(String[] args) {
        int test1 = 11;
        int test2 = 128;

        System.out.println(returnNumberOfOneBits(test1));
        System.out.println(returnNumberOfOneBits(test2));
    }  
}
