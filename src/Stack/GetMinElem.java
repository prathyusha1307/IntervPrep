package Stack;

import java.util.Stack;

public class GetMinElem {
	int min=0;
	Stack<Integer> s = new Stack<Integer>();
	
	public void push(int x){
		if(s.isEmpty()){
			s.push(x);
			min=x;
		}
		if(x<=min){
			s.push(2*x-min);
			min=x;
		}else{
			s.push(x);
		}
	}
	
	public void pop() throws Exception{
		if(s.isEmpty()){
			throw new Exception("stack is full");
		}
		int t=s.pop();
		if(t<min){
			System.out.println(min);
			min=2*min-t;
		}else{
			System.out.println(t);
		}
	}
	public static void main(String[] args) throws Exception {
		GetMinElem g = new GetMinElem();
		g.push(4);
		g.push(2);
		g.push(6);
		g.push(3);
		g.push(1);
		g.pop();
	}
}
