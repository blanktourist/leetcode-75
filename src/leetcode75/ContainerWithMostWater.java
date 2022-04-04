package leetcode75;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Ex. 1
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 * Ex. 2
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {
    
    public static int returnMostAmountOfWater(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int max = 0;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            int vol = height * width;
            max = Math.max(max, vol);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test1 = {1,8,6,2,5,4,8,3,7};
        int[] test2 = {1, 1};

        System.out.println(returnMostAmountOfWater(test1));
        System.out.println(returnMostAmountOfWater(test2));
    }
}
