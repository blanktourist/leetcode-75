package main.problems.binary;

public class MissingNumber {
    
    public static int returnMissingNumber(int[] arr) {
        int expectedSum = arr.length * (arr.length + 1) / 2;
        
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return expectedSum - sum;
    }
    
    public static void main(String[] args) {
        int[] test1 = {3,0,1};
        int[] test2 = {0,1};
        int[] test3 = {9,6,4,2,3,5,7,0,1};
        
        System.out.println(returnMissingNumber(test1));
        System.out.println(returnMissingNumber(test2));
        System.out.println(returnMissingNumber(test3));
    }
}
