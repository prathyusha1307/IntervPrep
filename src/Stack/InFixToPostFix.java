package Stack;

import java.util.Stack;

public class InFixToPostFix {

	public void toPostFix(String str){
		Stack<Character> s = new Stack<Character>();
		char[] arr =str.toCharArray();
		String postfix="";
		for(char c: arr){
			if(Character.isLetter(c)){
				postfix=postfix+c;
			}
			else if(c=='('){
				s.push(c);
			}else if(c==')'){
				while(s.peek()!='('){
					postfix=postfix+s.pop();
				}
				s.pop();
			}else{
				while(!s.isEmpty() && s.peek()!='(' && valueOfOperator(s.peek())>=valueOfOperator(c)){
					postfix=postfix+s.pop();
				}
				s.push(c);
			}
		}
		while(!s.isEmpty()){
			postfix=postfix+s.pop();
		}
		System.out.println(postfix);
	}
	
	public int valueOfOperator(char c1){
		if(c1=='+' || c1=='-'){
			return 1;
		}
		if(c1=='/' || c1=='*'){
			return 2;
		}
		return 0;
	}
	public static void main(String[] args) {
		InFixToPostFix i = new InFixToPostFix();
		i.toPostFix("(A+B)*C-D");
	}
}
