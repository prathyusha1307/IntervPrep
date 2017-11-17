package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_OP_lUsingQueue {

	Stack<Integer> s = new Stack<Integer>();
	
	public void stackImpl(Queue<Integer> q){

		while(!q.isEmpty()){
			s.push(q.poll());
		}
		
		while(!s.isEmpty()){
			q.add(s.pop());
		}
		
		while(!q.isEmpty()){
			s.push(q.poll());
		}
		
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	public static void main(String[] args) {
		Stack_OP_lUsingQueue s = new Stack_OP_lUsingQueue();
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		s.stackImpl(q);
	}
}
