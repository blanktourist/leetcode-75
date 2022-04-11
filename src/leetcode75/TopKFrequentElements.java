import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] returnTopKFrequentElements(int[] arr, int k) {
        if (k == arr.length ) {
            return arr;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> topK = new PriorityQueue<>((a,b) -> count.get(a) - count.get(b));
        for (int n : count.keySet()) {
            topK.add(n);
            if (topK.size() > k) {
                topK.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i< result.length; i++) {
            result[i] = topK.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1,2,2,3};
        int k1 = 2;

        System.out.println(Arrays.toString(returnTopKFrequentElements(arr1, k1)));
    }
}
