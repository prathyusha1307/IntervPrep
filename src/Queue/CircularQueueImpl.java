package Queue;

public class CircularQueueImpl {

	int rear=0;
	int front=0;
	int[] arr;
	int size=0;
	int capacity=0;
	
	public CircularQueueImpl(int n) {
		this.arr= new int[n];
		this.capacity=n;
	}
	
	public boolean isFull(){
		return size==capacity;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void enqueue(int x) throws Exception{
		if(isFull()){
			throw new Exception("queue is full");
		}else{
			arr[rear]=x;
			rear=(rear+1)%capacity;
			size++;
		}
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
