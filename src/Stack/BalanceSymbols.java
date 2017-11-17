package Stack;

import java.util.Stack;

public class BalanceSymbols {

	public boolean isBalanced(char[] str){
		boolean flag=false;
		Stack<Character> s = new Stack<Character>();
		for(char s1:str){
			if(s1=='{' || s1=='(' || s1=='['){
				s.push(s1);
			}else{
				char q=s.pop();
				if(q=='(' && s1==')'){
					flag=true;
				}
				else if(q=='[' && s1==']'){
					flag=true;
				}
				else if(q=='{' && s1=='}'){
					flag=true;
				}
			}
		}
		if(!s.isEmpty()){
			flag=false;
		}
		return flag;
	}
	public static void main(String[] args) {
		BalanceSymbols b = new BalanceSymbols();
		String str= "()(()[()])";
		System.out.println(b.isBalanced(str.toCharArray()));
	}
}
