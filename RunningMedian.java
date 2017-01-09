import java.util.*;

public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(n);
		minQ.add(Integer.MAX_VALUE);
		
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(n, Collections.reverseOrder());
		maxQ.add(Integer.MIN_VALUE);
		
		int a;
		float median = 0;
		for (int i = 0; i<n;i++) {
			a = in.nextInt();
            // adding the number to proper heap
            
			if (a >= minQ.peek())
				minQ.add(a);
			else
				maxQ.add(a);
			
			// balancing the heaps
			if (minQ.size() - maxQ.size() == 2)
				maxQ.add(minQ.poll());
			else if (maxQ.size() - minQ.size() == 2)
				minQ.add(maxQ.poll());
			
			// returning the median
			if (minQ.size() == maxQ.size())
				median = ((float)minQ.peek() + (float)maxQ.peek()) / 2;
			else if (minQ.size() > maxQ.size())
				median =  minQ.peek();
			else
				median =  maxQ.peek();

			System.out.println(median);
		}
		in.close();
	}

}
