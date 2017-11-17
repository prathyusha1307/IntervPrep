package LinkedList;


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

	PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.val-o2.val;
		}
	});
	
	public void sortKList(Node[] n){
		for(Node x:n){
			pq.add(x);
		}
		
		Node head= new Node(0);
		Node p=head;
		while(!pq.isEmpty()){
			Node temp=pq.poll();
			p.next=temp;
			p=p.next;
			if(temp.next!=null){
				pq.add(temp.next);
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
