package Stack;

import java.util.Stack;

public class EvaluatePostFix {

	public void eval(String str){
		char[] arr=str.toCharArray();
		Stack<Integer> s = new Stack<Integer>();
		for(char c:arr){
			if(isOperator(Character.toString(c))){
				int a =s.pop();
				int b=s.pop();
				int c1=0;
				switch(c){
				case '+': 
					c1=a+b;
					s.push(c1);
					break;
				case '-':
					c1=a-b;
					s.push(c1);
					break;
				case '/':
					c1=a/b;
					s.push(c1);
					break;
				case '*':
					c1=a*b;
					s.push(c1);
					break;
				}
			}else{
				s.push(Integer.parseInt(Character.toString(c)));
			}
		}
		System.out.println(s.pop());
	}
	
	public boolean isOperator(String c){
		String s="+-*%/";
		if(s.contains(c)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		EvaluatePostFix e = new EvaluatePostFix();
		e.eval("123*+5-");
	}
}
