package Stack;

import java.util.Stack;

public class EvaluateInfixExp {

	public void eval(String str){
		char[] tokens=str.toCharArray();
		Stack<Integer> s1= new Stack<Integer>();
		Stack<Character> s2= new Stack<Character>();
		for(int i=0; i<tokens.length;i++){
			if(tokens[i]>='0' && tokens[i]<='9'){
				StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                s1.push(Integer.parseInt(sbuf.toString()));
			}
			else if(tokens[i]=='('){
				s2.push(tokens[i]);
			}else if(tokens[i]==')'){
				while(s2.peek()!='('){
					s1.push(calc(s2.pop(),s1.pop(),s1.pop()));
				}
				s2.pop();
			}else{
				while(!s2.isEmpty() && s2.peek()!=')' && valueOfOperator(s2.peek())>=valueOfOperator(tokens[i])){
					s1.push(calc(s2.peek(),s1.pop(),s1.pop()));
				}
				s2.push(tokens[i]);
			}
		}
		
		while(!s2.isEmpty()){
			s1.push(calc(s2.pop(), s1.pop(), s1.pop()));
		}
		System.out.println(s1.pop());
	}
	
	public int calc(char c, int a, int b){
		int c1=0;
		switch(c){
		case '+': 
			c1=a+b;
			break;
		case '-':
			c1=a-b;
			break;
		case '/':
			c1=a/b;
			break;
		case '*':
			c1=a*b;
			break;
		}
		return c1;
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
		EvaluateInfixExp e = new EvaluateInfixExp();
		e.eval("10+2*6");
	}
}
