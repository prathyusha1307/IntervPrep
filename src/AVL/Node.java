package AVL;

public class Node {
	Node left;
	Node right;
	int height;
	int val;
	Node(int d){
		val=d;
		height=1;
	}
}
