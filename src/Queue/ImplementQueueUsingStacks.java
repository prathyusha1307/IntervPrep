package Queue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	Stack<Integer> s1= new Stack<Integer>();
	Stack<Integer> s2= new Stack<Integer>();
	
	public void enqueue(int val){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(val);
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}
	
	public int dequeue() throws Exception{
		if(s1.isEmpty()){
			throw new Exception("stack is empty");
		}
		int t=s1.pop();
		return t;
	}
	public static void main(String[] args) throws Exception {
		ImplementQueueUsingStacks i = new ImplementQueueUsingStacks();
		i.enqueue(1);
		i.enqueue(2);
		i.enqueue(3);
		System.out.println(i.dequeue());
		System.out.println(i.dequeue());
	}
}
