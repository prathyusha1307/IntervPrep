package Queue;

public class DynamicCircularArray {


	int rear=0;
	int front=0;
	int[] arr;
	int size=0;
	int capacity=0;
	int mincapacity=0;
	
	public DynamicCircularArray(int n) {
		this.arr= new int[n];
		this.capacity=n;
		this.mincapacity=(int) (0.75*n);
	}
	
	public boolean isFull(){
		return size==capacity;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void enqueue(int x) throws Exception{
		if(isFull()){
			expand();
		}else{
			arr[rear]=x;
			rear=(rear+1)%capacity;
			size++;
		}
	}
	
	private void expand() {	
		int[] newqueue= new int[2*size];
		for(int i=0;i<arr.length;i++){
			newqueue[i]=arr[i];
		}
		arr=newqueue;
		front=0;
		rear=size-1;
		capacity=2*capacity;
		
	}
	
	private void shrink() {
		capacity=mincapacity;
		int[] newqueue= new int[capacity];
		for(int i=0;i<arr.length;i++){
			newqueue[i]=arr[i];
		}
		arr=newqueue;
		
	}

	public int dequeue() throws Exception{
		int temp=0;
		if(isEmpty()){
			throw new Exception("queue is empty");
		}else{
			size--;
			 temp=arr[front%capacity];
			 arr[front]=Integer.MIN_VALUE;
			front=(front+1)%capacity;
			if(size<mincapacity){
				shrink();
			}
		}
		return temp;
	}
	
	public static void main(String[] args) throws Exception {
	CircularQueueImpl c = new CircularQueueImpl(5);
	c.enqueue(1);
	c.enqueue(2);
	c.enqueue(3);
	c.enqueue(4);
	c.enqueue(5);
	System.out.println(c.dequeue());
	System.out.println(c.dequeue());
	}

}
