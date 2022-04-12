package main.problems.binary;

public class ReverseBits {
   
   public static int returnReverseBits(int n) {
       int result = 0;

       for (int i = 0 ; i<32; i ++) {
            result = result << 1;
            result = result | (n & 1);
            n >>= 1;
       }

       return result;
   }
    public static void main(String[] args) {
       System.out.println(returnReverseBits(43261596));
   } 
}
