package Stack;

public class StackImplUsingArray {

	int capactity=0;
	int top=-1;
	int[] arr;
	
	public StackImplUsingArray(int val) {
		this.capactity=val;
		arr= new int[capactity];
	}
	
	public boolean isEmpty(){
		if(top<-1){
			return true;
		}
		return false;
	}
	
	public int size(){
		return top+1;
	}
	
	public void push(int val) throws Exception{
		if(size()==capactity){
			throw new Exception("Stack is full");
		}
		arr[++top]=val;
	}
	
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is full");
		}
		int val=arr[top];
		top--;
		return val;
	}
	
	public int top() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is full");
		}
		return arr[top];
	}
	public static void main(String[] args) throws Exception {
		StackImplUsingArray s = new StackImplUsingArray(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.top());
	}
}
