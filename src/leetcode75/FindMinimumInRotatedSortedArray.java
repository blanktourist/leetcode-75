public class FindMinimumInRotatedSortedArray {
    
    public static int returnMinIndexInRotatedSortedArray(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) {
            return 0;
        }
        
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid - 1]) {
                return mid;
            }

            if ((arr[mid] > arr[mid + 1])) {
                return mid + 1;
            }


            if (arr[l] < arr[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] test1 = {3,4,5,1,2};
        int[] test2 = {4,5,6,7,0,1,2};
        int[] test3 = {11,13,15,17};

        System.out.println(test1[returnMinIndexInRotatedSortedArray(test1)]);
        System.out.println(test2[returnMinIndexInRotatedSortedArray(test2)]);
        System.out.println(test3[returnMinIndexInRotatedSortedArray(test3)]);
    }
}
