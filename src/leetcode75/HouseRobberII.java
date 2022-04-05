import java.util.Arrays;

public class HouseRobberII {
    
    public static int returnSolutionToHouseRobberII(int[] houses) {
        int[] slice1 = Arrays.copyOfRange(houses, 0, houses.length - 1);
        int[] slice2 = Arrays.copyOfRange(houses, 1, houses.length);
        int answerForSlice1 = HouseRobber.returnSolutionToHouseRobber(slice1);
        int answerForSlice2 = HouseRobber.returnSolutionToHouseRobber(slice2);

        return Math.max(answerForSlice1, answerForSlice2);
    }
    
    public static void main(String[] args) {
        int[] test1 = {2,3,2};
        int[] test2 = {1,2,3,1};
        int[] test3 = {1,2,3};

        System.out.println(returnSolutionToHouseRobberII(test1));
        System.out.println(returnSolutionToHouseRobberII(test2));
        System.out.println(returnSolutionToHouseRobberII(test3));
    }
}
