package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingQueue {

	Queue<Integer> q1= new LinkedList<Integer>();
	Queue<Integer> q2= new LinkedList<Integer>();
	
	public void push(int val){
		while(!q1.isEmpty()){
			q2.add(q1.poll());
		}
		q1.add(val);
		while(!q2.isEmpty()){
			q1.add(q2.poll());
		}
	}
	
	public int pop() throws Exception{
		if(q1.isEmpty()){
			throw new Exception("stack is empty");
		}
		int t=q1.poll();
		return t;
	}
	public static void main(String[] args) throws Exception {
		StackImplUsingQueue s = new StackImplUsingQueue();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
