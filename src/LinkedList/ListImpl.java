package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class ListImpl {
	Node head;
	Node sorted;
	ListImpl(int n){
		head = new Node(n);
		sorted=null;
	}
	
	public void insert(int n){
		if(head==null){
			head= new Node(n);
		}else{
			Node n1= head;
			while(n1.next!=null){
				n1=n1.next;
			}
			n1.next= new Node(n);
		}
	}
	
	public void print(){
		Node n=head;
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
	}
	
	public void printUsingRecursion(Node head){
		if(head==null){
			return;
		}
		printUsingRecursion(head.next);
		System.out.println(head.val);
	}
	
	
	public boolean isLLEven(){
		Node l1=head;
		while(l1!=null && l1.next!=null){
			l1=l1.next.next;
		}
		if(l1!=null){
			return false;
		}
		return true;	
	}
	
	public Node mergeSortedLL(Node head1, Node head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		Node n1=head1;
		Node n2=head2;
		Node h= new Node(0);
		if(n2.val<n1.val){
			h.next=n2;
			h.next=mergeSortedLL(head1, head2.next);
		}else{
			h.next=n1;
			h.next= mergeSortedLL(head1.next, head2);
		}
		return h;
	}
	
	public void mergeSortedList(Node head1, Node head2){
		Node n= new Node(0);
		Node n1=head1;
		Node n2=head2;
		while(n1!=null && n2!=null){
			if(n1.val<n2.val){
				n.next=n1;
				n1=n1.next;
				n=n.next;
			}else{
				n.next=n2;
				n2=n2.next;
				n=n.next;
			}
		}
		if(n1!=null){
			n.next=n1;
		}else if(n2!=null){
			n.next=n2;
		}
	}
	public void getNthFromEnd(int y){
		Node temp=head;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		int n=count-y;
		Node curr=head;
		for(int i=0;i<n;i++){
			curr=curr.next;
		}
		System.out.println(curr.val);
	}
	public void getNthNodeUsing2Pointers(int n){
		Node curr=head;
		Node prev=head;
		while(n>0){
			curr=curr.next;
			n--;
		}
		while(curr.next!=null){
			prev=prev.next;
			curr=curr.next;
		}
		System.out.println(prev.val);
	}
	
	public Node getNthNodeUsingRecurssion(Node head, int n){
		int count=0;
		if(head!=null){
			getNthNodeUsingRecurssion(head.next, n);
			count++;
			if(count==n){
				return head;
			}
		}
		return null;
	}
	
	public boolean findLoop(){
		Node slow=head;
		Node fast=head;
		boolean isLoopExists=false;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				isLoopExists= true;
				break;
			}
		}
		return isLoopExists;
	}
	
	public Node beginNodeOfLoop(){
		Node slow=head;
		Node fast=head;
		boolean isLoopExists=false;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				isLoopExists= true;
				break;
			}
		}
		slow=head;
		if(isLoopExists){
			while(fast!=slow){
				slow=slow.next;
				fast=fast.next;
			}
			return fast;
		}else{
			return null;
		}
	}
	
	public void findMiddleNode(){
		Node n1=head;
		Node n2=head;
		while(n1!=null && n1.next!=null){
			n1=n1.next.next;
			n2=n2.next;
		}
		System.out.println(n2.val);
	}
	
	public void insertNodeInSortedList(Node n){
		if(head==null){
			return ;
		}
			Node curr=head;
			Node prev=head;
			while(curr!=null && curr.val<n.val){
				prev=curr;
				curr=prev.next;
			}
			prev.next=n;
			n.next=curr;
			prev=n;	
	}
	
	
	public int getIntersection(){
		Node n1=head;
		Node n2=head;
		int l1=getLength(n1);
		int l2=getLength(n2);
		int diff=0;
		if(l1>l2){
			diff=l1-l2;
			for(int i=0;i<diff;i++){
				n1=n1.next;
			}
			while(n1!=null){
				if(n1.val==n2.val){
					return n1.val;
				}
				n1=n1.next;
				n2=n2.next;
			}
		}else{

			diff=l2-l1;
			for(int i=0;i<diff;i++){
				n2=n2.next;
			}
			while(n2!=null){
				if(n1.val==n2.val){
					return n1.val;
				}
				n1=n1.next;
				n2=n2.next;
			}
		
		}
		return 0;
		
	}
	private int getLength(Node n1) {
		Node curr=n1;
		int counter=0;
		while(curr!=null){
			curr=curr.next;
			counter++;
		}
		return counter;
	}

	public Node reverseLinkedList(Node head){
		Node prev=null;
		Node curr=head;		
		while(curr!=null){
			Node n=curr.next;
			curr.next=prev;
			prev=curr;
			curr=n;
		}
		head= prev;
		return head;
	}
	
	public Node reverseLLUsingRecursion(Node curr, Node prev ){
		if(curr.next==null){
			head=curr;
			curr.next=prev;
			return head;
		}
		Node next= curr.next;
		curr.next=prev;
		reverseLLUsingRecursion(next, curr);
		return head;
	}
	public int lengthOfLoop(){
		Node slow=head;
		Node fast=head;
		boolean isLoopExists=false;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				isLoopExists= true;
				break;
			}
		}
		slow=head;
		int length=0;
		if(isLoopExists){
			do{
				slow=slow.next;
				length++;
			}while(slow!=fast);
			return length;
		}else{
			return length;
		}
	}
	
	public void pairreversalWithoutLink(Node head){
		Node n1=head;
		while(n1!=null && n1.next!=null){
			int temp=n1.val;
			n1.val=n1.next.val;
			n1.next.val=temp;
			n1=n1.next.next;
		}
	}
	
	public void pairreversal(Node head){
		Node prev=head;
		Node curr=head.next;
		Node node=curr;
		while(true){
			Node n=curr.next;
			curr.next=prev;
			if(n==null || n.next==null){
				prev.next=n;
				break;
			}
			prev.next=n.next;
			prev=n;
			curr=prev.next;
		}
		this.head=node;
	}
	
	
	public Node pairreversalusingrecursion(Node head){
		Node prev=head;
		Node curr=head.next;
		if(head==null || head.next==null){
			return head;
		}
		Node n=head.next.next;
		Node newhead=head.next;
		curr.next=prev;
		prev.next=pairreversalusingrecursion(n);
		return newhead;
	}
	
	public void sortLL(Node head1, Node head2){
		Node n1=head1;
		Node n2=head2;
		Node h= new Node(0);
		while(n1!=null && n2!=null){
			if(n1.val<n2.val){
				h.next=n1;
				h=h.next;
				n1=n1.next;				
			}else{
				h.next=n2;
				h=h.next;
				n2=n2.next;	
			}
		}	
		while(n1!=null){
			h.next= n1;
			h=h.next;
			n1=n1.next;
		}
		
		while(n2!=null){
			h.next=n2;
			h=h.next;
			n2=n2.next;
		}
	}
	
	public void splitCLL(Node head){
		Node slow=head;
		Node fast=head;
		while(fast.next!=head || fast.next.next!=head){
			fast=fast.next.next;
			slow=slow.next;
		}
		if(fast.next.next==head){
			fast=fast.next;
		}
		Node head1=head;
		Node head2=null;
		if(head.next!=head){
			head2=slow.next;
		}
		fast.next=slow.next;
		slow.next=head;
	}
	
	public boolean isPalindrome(Node head){
		Node slow=head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		Node head2=slow.next;
		slow.next=null;
		Node n1=reverseLinkedList(head2);
		Node n2=head;
		while(n1!=null && n2!=null){
			if(n1.val!=n2.val){
				return false;
			}
			n1=n1.next;
			n2=n2.next;
		}
		return true;
	
	}
	
	public Node swaapKNodes(Node head, int k){
		Node curr=head;
		Node next=null;
		Node prev=null;
		int i=0;
		while(i<k && curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			i++;
		}
		if(next!=null){
			head.next=swaapKNodes(next, k);
		}
		return prev;
	}
	
	Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(next, k);
 
       // prev is now head of input list
       return prev;
    }  
	public Node swapKNodes(	Node head,int k){
		if(head==null || k==1){
			return head;
		}
		Node fake=new Node(0);
		fake.next=head;
		Node p=head;
		Node prev=fake;
		int i=0;
		while(p!=null){
			i++;
			if(i%k==0){
				prev=reverse(prev,p.next);
				p=prev.next;
			}else{
				p=p.next;
			}
		}
		return fake.next;
	}
	
	private Node reverse(Node prev, Node next) {
		Node last=prev.next;
		Node curr=last.next;
		while(curr!=next){
			last.next=curr.next;
			curr.next=prev.next;
			prev.next=curr;
			curr=last.next;
		}
		return last;
	}

	public void creatCLLanDeleteMNodes(int n, int m){
		Node p=new Node(1);
		Node p1=p;
		for(int i=2;i<=n;i++){
			p.next= new Node(i);
			p=p.next;
		}
		p.next=p1;
		
		for(int count=n;count>0;count--){
			
			for(int j=0;j<m;j++){
				p=p.next;
			}
			p.next=p.next.next;
		}
		System.out.println(p.val);
	}
	
	public Node clone(){
		Node origNode=head;
		Node copyNode=null;
		Map<Node,Node> map = new HashMap<Node, Node>();
		while(origNode!=null){
			copyNode= new Node(origNode.val);
			map.put(origNode, copyNode);
			copyNode.next=null;
			origNode=origNode.next;
		}
		
		origNode=head;
		while(origNode!=null){
			copyNode=map.get(origNode);
			copyNode.next=map.get(origNode.next);
			origNode=origNode.next;
		}
		return map.get(head);
	}
	
	public void findModularNode(Node head, int k){
		Node p=head;
		int i=0;
		Node curr=null;
		while(p!=null){
			if(i%k==0){
				curr=p;
			}
				p=p.next;
			i++;
		}
		System.out.println(curr.val);
	}
	
	public void rearrange(Node head){
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		Node h=slow.next;
		Node head2=reverseLinkedList(h);
		Node head1=head;
		while(head1!=null && head2!=null){
			Node temp=head1.next;
			head1.next=head2;
			head1=temp;
			head2=head2.next;
		}
	}
	
	public void insertionSort(Node head){
		Node curr=head;
		while(curr!=null){
			Node next=curr.next;
			sort(curr);
			curr=next;
		}
		head=sorted;
	}
	private void sort(Node curr) {
		if(sorted==null || sorted.val>=curr.val){
			Node newnode=curr;
			newnode.next=sorted;
			sorted=newnode;
		}else{
			Node n=sorted;
			while(n.next!=null && n.next.val<curr.val){
				n=n.next;
			}
			curr.next=n.next;
			n.next=curr;
		}
	}

	
	public void rotatebyKNodes(int k){
		Node curr=head;
		Node last=null;
		Node newhead=null;
		Node t=head;
		while(curr.next!=null){
			if(k==0){
				last=curr;
				newhead=curr.next;
			}
			curr=curr.next;
			k--;
		}
		
		curr.next=t;
		last.next=null;
		head=newhead;
		
	}
	
	public Node sumofLL(Node head1, Node head2){
		Node temp=new Node(0);
		Node head3=temp;
		Node t1=head1;
		Node t2=head2;
		int sum=0;
		int carry=0;
		while(t1!=null && t2!=null){
			sum=sum+t1.val+t2.val+carry;
			carry=sum/10;
			sum=sum%10;
			temp.next= new Node(sum);
			temp=temp.next;
			t1=t1.next;
			t2=t2.next;
		}
		if(t1!=null){
			if(carry>0){
				temp.next=sumofLL(t1, new Node(carry));
			}else{
				temp.next=t1;
			}
		} else if(t2!=null){
			if(carry>0){
				temp.next=sumofLL(t2, new Node(carry));
			}else{
				temp.next=t2;
			}
		}else if(carry!=0){
			temp.next= new Node(carry);
		}
		return head3.next;
	}
	
	public void partition(Node head, int k){
		Node curr=head;
		Node root=new Node(0);
		Node p=root;
		Node pivot=new Node(0);
		Node t=pivot;
		while(curr!=null){
			if(curr.val<=k){
				root.next=curr;
				root=curr;
			}else{
				pivot.next=curr;
				pivot=curr;
			}
			curr=curr.next;
		}
		root.next=t.next;
		t.next=null;
		head=p.next;
		
	}
	
	
	public void removeDup(Node  head){
		Node curr=head;
		Node prev=null;
		Node curr2=null;
		while(curr!=null){
			prev=curr;
			curr2=curr.next;
			while(curr2!=null){
				if(curr.val==curr2.val){
					prev.next=curr2.next;
					prev=prev.next;
				}
				prev=curr2;
				curr2=curr2.next;
			}
			curr=curr.next;
		}
	}
	
	public void partitionOdd_Even(Node head){
		Node p1= new Node(0);
		Node h=p1;
		Node p2= new Node(0);
		Node t=p2;
		Node curr=head;
		while(curr!=null){
			if(curr.val%2==0){
				p1.next=new Node(curr.val);
				p1=p1.next;
			}else{
				p2.next=new Node(curr.val);
				p2=p2.next;
			}
			curr=curr.next;
		}
		p1.next=t.next;
		this.head=h.next;
	}
	public static void main(String[] args) {
		ListImpl l1 = new ListImpl(1);
		l1.insert(3);
		l1.insert(2);
		l1.insert(5);
		l1.insert(6);

		
		//l1.print();
		//l1.getNthNodeUsing2Pointers(2);
		//l1.insertNodeInSortedList(new Node(3));
		//l1.reverseLinkedList();
		//Node t=l1.reverseLLUsingRecursion(l1.head, null);		
		//l1.print();
		//l1.findMiddleNode();
		//l1.printUsingRecursion(l1.head);
		//System.out.println(l1.isLLEven());
		//l1.pairreversal(l1.head);
		//Node n=l1.pairreversalusingrecursion(l1.head);
		//l1.head=n;
		//l1.print();
		//System.out.println(l1.isPalindrome(l1.head));
		/*Node n=l1.swapKNodes(l1.head, 3);
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}*/
		//l1.print();
		//l1.creatCLLanDeleteMNodes(5, 2);
		//l1.findModularNode(l1.head, 2);
		l1.partitionOdd_Even(l1.head);
		l1.print();
	}
}
