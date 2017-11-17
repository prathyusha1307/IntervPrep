package LinkedList;

public class StackUsingArr {

	int top=-1;
	int[] arr;
	int max=10;
	public StackUsingArr(int n) {
		arr= new int[n];
	}

	public boolean push(int val){
		if(top>=max){
			return false;
		}else{
			arr[++top]=val;
			return true;
		}
	}

	public int pop(){
		if(top<0){
			return 0;
		}else{
			int data=arr[top];
			top--;
			return data;
		}
	}
	public static void main(String[] args) {
		StackUsingArr s = new StackUsingArr(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());

	}
}
