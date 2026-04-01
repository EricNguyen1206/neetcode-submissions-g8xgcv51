class MedianFinder {
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;

    public MedianFinder() {
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxQ.add(num);
        
        minQ.add(maxQ.poll());

        if (minQ.size() > maxQ.size()) {
            maxQ.add(minQ.poll());
        }
        
    }
    
    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
            return (maxQ.peek() + minQ.peek()) / 2.0;
        }

        return maxQ.peek();
    }
}
