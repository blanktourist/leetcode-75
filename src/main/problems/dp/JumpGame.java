public class JumpGame {
    
    public static boolean returnSolutionToJumpGame(int[] arr) {
        if (arr.length == 1) return true;
        
        boolean[] canReach = new boolean[arr.length];
        canReach[0] = true;

        for (int i = 0; i < arr.length; i++) {
            if (canReach[i]) {
                int jumpLength = arr[i];
                for (int j = 1; j <= jumpLength; j++) {
                    int jumpTo = i + j;
                    if (jumpTo > arr.length - 1) {
                        continue;
                    }
                    if (jumpTo == arr.length - 1) {
                        return true;
                    }
                    canReach[jumpTo] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {2,3,1,1,4};
        int[] test2 = {3,2,1,0,4};

        System.out.println(returnSolutionToJumpGame(test1));
        System.out.println(returnSolutionToJumpGame(test2));
    }
}
