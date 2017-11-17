package Stack;

class Node{
	Node next;
	int val;
	Node(int val){
		this.val=val;
	}
}
public class StackImplUsingLL {

	Node head;
	Node top;
	public StackImplUsingLL() {
		head=null;
		top=head;
	}
	
	public void push(int val){
		if(head==null){
			head=new Node(val);
			top=head;
		}else{
			Node newnode=new Node(val);
			newnode.next=head;
			head=newnode;
			top=head;
		}
	}
	
	public int pop(){
		int val=0;
		if(head==null){
			return val;
		}else{
			Node t=head.next;
			val=top.val;
			head.next=null;
			head=t;
			top=head;
		}
		return val;
	}
	public static void main(String[] args) {
		StackImplUsingLL l = new StackImplUsingLL();
		l.push(1);
		l.push(2);
		l.push(3);
		l.push(4);
		l.push(5);
		System.out.println(l.pop());
		System.out.println(l.pop());
	}
}
