import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static class MedianFinder {

        PriorityQueue<Integer> lo;
        PriorityQueue<Integer> hi;
        
        public MedianFinder() {
            lo = new PriorityQueue<>();
            hi = new PriorityQueue<>((a,b) -> b - a);
        }
        
        public void addNum(int num) {
            // Insert
            lo.add(num);
            hi.add(lo.peek());
            lo.poll();

            // Rebalance
            if (lo.size() < hi.size()) {
                lo.add(hi.peek());
                hi.poll();
            }
        }
        
        public double findMedian() {
            if (lo.size() > hi.size()) {
                return lo.peek();
            } else if (hi.size() > lo.size()) {
                return hi.peek();
            } else {
                return (lo.peek() * 1.0 + hi.peek()) * 0.5;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
