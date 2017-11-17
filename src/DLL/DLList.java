package DLL;

public class DLList {
	DLLNode head;
	DLLNode tail;
	int length;
	DLList(){
		head=new DLLNode(0,null,null);
		tail= new DLLNode(0,head,null);
		head.next=tail;
		length=0;
	}

	public int getPosition(int data){
		DLLNode temp=head;
		int pos=0;
		while(temp!=null){
			if(temp.data==data){
				return pos;
			}
			pos++;
			temp=temp.next;
		}
		return pos;
	}

	public void insert(int val){
		DLLNode newNode=new DLLNode(val,null,head.next);
		DLLNode temp=head;
		temp.prev=newNode;
		head=newNode;
		length++;
	}

	public void insert(int val, int pos){
		if(pos<0){
			pos=0;
		}
		if(pos>length){
			pos=length;
		}
		if(head==null){
			head= new DLLNode(val,null,null);
		}
		else if(pos==0){
			DLLNode temp = head;
			DLLNode newNode=new DLLNode(val,head,null);
			newNode.prev=temp;
			temp.next=newNode;
			newNode.next=null;
		}else{
			DLLNode t1=head;
			for(int i=0;i<pos ;i++){
				t1=t1.next;
			}
			DLLNode newNode=new DLLNode(val,t1, t1.next);
			newNode.prev=t1;
			newNode.next=t1.next;
			t1.next.prev=newNode;
			t1.next=newNode;
		}
		length++;

	}

	public void insertAtEnd(int val){
		DLLNode temp=head;
		int t=length;
		while(t>0){
			temp=temp.next;
			t--;
		}
		DLLNode newNode= new DLLNode(val,temp, temp.next);
		temp.next=newNode;
		newNode.prev=temp;
		newNode.next=null;
		length++;
	}


	public void remove(int val){
		if(head==null){
			return;
		}
		if(head.data==val){
			DLLNode temp=head;
			head=head.next;
			temp.next=null;
		}else{
			DLLNode temp=head;
			while(temp.next!=null){
				if(temp.data==val){
					break;
				}
				temp=temp.next;
			}
			if(temp.next!=null){
				DLLNode t=temp.next;
				temp.prev.next=t;
				t.prev=temp.prev;
			}else{
				DLLNode t= temp;
				t.prev.next=null;
				t.prev=null;
			}
			
		}
	}

public void print(){
	DLLNode temp=head;
	while(temp!=null){
		System.out.println(temp.data);
		temp=temp.next;
	}
}
public static void main(String[] args) {
	DLList l1= new DLList();
	l1.insert(1,0);
	l1.insertAtEnd(2);
	l1.insertAtEnd(4);
	l1.insertAtEnd(5);
	l1.insertAtEnd(6);
	l1.insert(3, 2);
	l1.remove(6);
	l1.print();
}
}
