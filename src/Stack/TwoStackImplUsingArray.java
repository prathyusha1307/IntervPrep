package Stack;

public class TwoStackImplUsingArray {

	int[] arr= new int[10];
	public TwoStackImplUsingArray(int[] arr) {
		this.arr=arr;
	}
	int x=0;
	int y=arr.length-1;
	public void push(int z, int stackid) throws Exception{
		if(x==y){
			throw new Exception("Array is full");
		}
		if(stackid==1){
			arr[x++]=z;
		}
		else if(stackid==2){
			arr[y--]=z;
		}else{
			return;
		}
	}
	
	public int pop(int stackid) throws Exception{
		if(stackid==1){
			if(x==-1){
				throw new Exception("Stack is empty");
			}
			int t=arr[--x];
			arr[x]=0;
			return t;
		}
		else if(stackid==2){
			if(y==-1){
				throw new Exception("Stack is empty");
			}
			int c=arr[++y];
			arr[y]=0;
			return c;
		}else{
			return 0;
		}
	}
	public static void main(String[] args) throws Exception {
		int[] arr= new int[10];
		TwoStackImplUsingArray t = new TwoStackImplUsingArray(arr);
		t.push(1, 1);
		t.push(2, 1);
		t.push(3, 1);
		t.push(4, 1);
		t.push(5, 2);
		t.push(6, 2);
		t.push(7, 2);
		t.push(8, 2);
		System.out.println(t.pop(1));
		System.out.println(t.pop(1));
		System.out.println(t.pop(2));
		System.out.println(t.pop(2));
	}
}
