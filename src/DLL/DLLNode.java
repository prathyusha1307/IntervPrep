package DLL;

public class DLLNode {

	DLLNode prev;
	DLLNode next;
	int data;
	DLLNode(int val, DLLNode prev, DLLNode next){
		data=val;
		this.prev=prev;
		this.next=next;
	}
}
