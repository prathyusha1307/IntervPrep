package Queue;

public class QueueImplUsingLL {

	Node front;
	Node rear;
	
	public QueueImplUsingLL() {
		front=null;
		rear=null;
	}
	
	public void enqueue(int val){
		if(rear==null && front==null){
			rear=new Node(val);
			front=rear;
		}else{
			Node temp=rear;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next= new Node(val);
		}
	}
	
	
	public int dequeue(){
		if(front==null){
			return 0;
		}else{
			Node t=front.next;
			int val=front.val;
			front.next=null;
			front=t;
			return val;
		}
	}
	
	public static void main(String[] args) {
		QueueImplUsingLL q = new QueueImplUsingLL();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}

class Node{
	Node next;
	int val;
	Node(int x){
		this.val=x;
	}
}
