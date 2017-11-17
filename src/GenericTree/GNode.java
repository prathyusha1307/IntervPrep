package GenericTree;

public class GNode {
	int data;
	GNode firstChild;
	GNode nextSibling;
	GNode(int val){
		this.data=val;
		firstChild=nextSibling=null;
	}
}
