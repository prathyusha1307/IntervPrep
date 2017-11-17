package Stack;

import java.util.Stack;

public class QueueImplUsingStacks {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2= new Stack<Integer>();
	
	public void enqueue(int x){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(x);
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}
	
	
	public int dequeue() throws Exception{
		if(s1.isEmpty()){
			throw new Exception("stack is empty");
		}
		return s1.pop();
	}
	public static void main(String[] args) throws Exception {
		QueueImplUsingStacks q= new QueueImplUsingStacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
