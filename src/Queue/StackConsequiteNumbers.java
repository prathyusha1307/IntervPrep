package Queue;

import java.util.Stack;

public class StackConsequiteNumbers {

	
	public boolean calc(Stack<Integer> s){
		boolean flag=false;
		while(!s.isEmpty()){
			int t1=s.pop();
			int t2=s.pop();
			int diff=t1-t2;
			if(diff==1 || diff==-1){
				flag=true;
			}else{
				break;
			}
			
		}
		return flag;
	}
	public static void main(String[] args) {
		StackConsequiteNumbers s = new StackConsequiteNumbers();
		Stack<Integer> s1= new Stack<>();
		s1.push(4);
		s1.push(5);
		s1.push(-2);
		s1.push(-3);
		s1.push(11);
		s1.push(10);
		s1.push(5);
		s1.push(6);
		s1.push(20);
		System.out.println(s.calc(s1));
	}
}
