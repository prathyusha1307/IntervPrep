package LinkedList;

public class StackUsingLL {

	Node head;
	public boolean push(int val){
		if(head==null){
			head=new Node(val);
		}else{
			Node newnode= new Node(val);
			newnode.next=head;
			head=newnode;
			return true;
		}
		return false;
	}
	
	public int pop(){
		if(head==null){
			return -1;
		}else{
			int data=head.val;
			head=head.next;
			return data;
		}
	}
	
	public static void main(String[] args) {
		StackUsingLL s = new StackUsingLL();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
