package CLL;

public class CLLList {
	CLLNode tail;
	int lenght;

	public void addNode(int val){
		if(tail==null){
			tail= new CLLNode(val);
			tail.data=val;
			tail.next=tail;
		}else{
			CLLNode temp= tail;
			CLLNode newnode=new CLLNode(val);
			while(temp.next!=tail){
				temp=temp.next;
			}
			newnode.next=tail;
			temp.next=newnode;
		}
	}
	public void print(){
		CLLNode temp=tail;
		while(temp.next!=tail){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	public void remove(int data){
		if(tail==null){
			return;
		}
		if(tail.next==tail && tail.data==data){
			tail.next=null;
		}
		CLLNode temp=tail;
			while(temp.next!=tail)	{
				if(temp.next.data==data){
					break;
				}
				temp=temp.next;
			}
			CLLNode t= temp.next;
			temp.next=temp.next.next;
			t.next=null;
		}

	

	public static void main(String[] args) {
		CLLList c = new CLLList();
		c.addNode(1);
		c.addNode(2);
		c.addNode(3);
		c.addNode(4);
		c.remove(1);
		c.print();
	}
}
