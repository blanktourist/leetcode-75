public class SearchInRotatedSortedArray {

    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     * 
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     * 
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * Ex. 1
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * 
     * Ex. 2
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * 
     * Ex. 3
     * Input: nums = [1], target = 0
     * Output: -1
     * 
     * @param arr
     * @param target
     */
    public static int returnIndexOfTargetInRotatedArray(int[] arr, int target) {
        if (arr.length == 0) return -1;

        if (arr.length == 1) return arr[0] == target ? 0 : -1;

        int pivot = FindMinimumInRotatedSortedArray.returnMinIndexInRotatedSortedArray(arr);

        if (arr[pivot] == target) return pivot;

        if (pivot == 0) {
            return binarySearch(arr, target, 0, arr.length - 1);
        } else if (target < arr[0]) {
            return binarySearch(arr, target, pivot, arr.length -1);
        } else {
            return binarySearch(arr, target, 0, pivot);
        }
    }

    private static int binarySearch(int[] arr, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;

            if (target < arr[mid]) r = mid - 1;

            else l = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        int[] test2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int[] test3 = {1};
        int target3 = 0;

        System.out.println(returnIndexOfTargetInRotatedArray(test1, target1));
        System.out.println(returnIndexOfTargetInRotatedArray(test2, target2));
        System.out.println(returnIndexOfTargetInRotatedArray(test3, target3));
    }
}