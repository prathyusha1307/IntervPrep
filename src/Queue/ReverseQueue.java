package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	public void reverse(Queue<Integer> q){
		Stack<Integer> s = new Stack<Integer>();
		while(!q.isEmpty()){
			s.push(q.poll());
		}
		while(!s.isEmpty()){
			q.add(s.pop());
		}
		
		while(!q.isEmpty()){
			System.out.println(q.poll());
		}
	}
	public static void main(String[] args) {
		ReverseQueue r1 = new ReverseQueue();
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		r1.reverse(q);
	}
}
