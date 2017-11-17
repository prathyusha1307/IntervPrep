package Stack;

public class StackImplUsingDynamicArray {

	int capacity;
	int top=-1;
	int[] arr;
	int[] newstack;

	public StackImplUsingDynamicArray(int val) {
		this.capacity=val;
		arr= new int[capacity];
	}

	public boolean isEmpty(){
		if(top<0){
			return true;
		}
		return false;
	}

	public boolean isFull(){
		if(size()==capacity){
			return true;
		}
		return false;
	}

	public int size(){
		return top+1;
	}

	public void increasecapacity(){
		int val=this.capacity*2;
		newstack= new int[val];
		for(int i=0;i<arr.length;i++){
			newstack[i]=arr[i];
		}
		this.capacity=val;
		this.arr=newstack;
	}
	
	public void decreasecapacity(){
		int val=this.capacity/2;
		newstack= new int[val];
		System.arraycopy(arr, 0, newstack, 0, val);
		this.capacity=val;
		this.arr=newstack;
	}

	public void push(int val){
		if(isFull()){
			this.increasecapacity();
		}
		arr[++top]=val;
	}
	
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("stack is empty");
		}
		int val=arr[top--];
		decreasecapacity();
		return val;
	}
	public static void main(String[] args) throws Exception {
		StackImplUsingDynamicArray s = new StackImplUsingDynamicArray(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
