public class SumOfTwoIntegers {
    /**
     * Given two integers a and b, return the sum of the two integers without using the operators + and -.
     * 
     * Ex. 1
     * Input: a = 1, b = 2
     * Output: 3
     * 
     * Ex. 2
     * Input: a = 2, b = 3
     * Output: 5
     * 
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b ) << 1;
            a = answer;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(2, 3));
        System.out.println(add(997, 998));
    }
}
