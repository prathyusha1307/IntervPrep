package Stack;

import java.util.Stack;

public class SortStack {

	Stack<Integer> s1= new Stack<Integer>();
	
	public void sort(Stack<Integer> s){
		while(!s.isEmpty()){
			int temp=s.pop();
			while(!s1.isEmpty() && s1.peek()<temp){
				s.push(s1.pop());
			}
			s1.push(temp);
		}
		while(!s1.isEmpty()){
			System.out.println(s1.pop());
		}
	}
	public static void main(String[] args) {
		SortStack s = new SortStack();
		Stack<Integer> p = new Stack<Integer>();
		p.push(4);
		p.push(5);
		p.push(2);
		p.push(3);
		p.push(1);
		s.sort(p);
	}
}
