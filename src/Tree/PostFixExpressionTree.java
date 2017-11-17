package Tree;

import java.util.Stack;

public class PostFixExpressionTree {

	public ExpNode postExpTree(char[] postfix){
		Stack<ExpNode> s = new Stack<ExpNode>();
		for(int i=0;i<postfix.length;i++){
			if(!isoperator(postfix[i])){
				ExpNode t= new ExpNode(postfix[i]);
				s.push(t);
			}else{
				ExpNode t1= new ExpNode(postfix[i]);
				ExpNode t2=s.pop();
				ExpNode t3=s.pop();
				t1.left=t3;
				t1.right=t2;
				s.push(t1);
			}
		}
		ExpNode t=s.peek();
		s.pop();
		return t;
	}
	
	public boolean isoperator(char c){
		if(c=='-' || c=='+' || c=='*' || c=='/' ){
			return true;
		}
		return false;
	}
	 void inorder(ExpNode t) {
	        if (t != null) {
	            inorder(t.left);
	            System.out.print(t.value + " ");
	            inorder(t.right);
	        }
	    }
	public static void main(String[] args) {
		PostFixExpressionTree p = new PostFixExpressionTree();
		String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
		p.inorder(p.postExpTree(charArray));
	}
}

class ExpNode {

 char value;
 ExpNode left, right;

 ExpNode(char item) {
     value = item;
     left = right = null;
 }
}
