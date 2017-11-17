package Tree;

public class Node {
	Node left;
	Node right;
	Node rightsibling;
	int val;
	Node(int data){
		this.val=data;
		left=right=rightsibling=null;
	}
}
