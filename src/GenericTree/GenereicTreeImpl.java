package GenericTree;

import Tree.Node;
import Tree.TreeImpl;

public class GenereicTreeImpl {

	GNode root;
	
	public int sumOfNodes(GNode root){
		if(root==null){
			return 0;
		}
		return root.data+sumOfNodes(root.firstChild)+sumOfNodes(root.nextSibling);
	}
	
	public void maxdepth(int[] p){
		int maxdepth=-1; int depth=-1;int j=0;
		for(int i=0;i<p.length;i++){
			depth=0;
			j=i;
			while(p[j]!=-1){
				depth++;
				j=p[j];
			}
			if(maxdepth<depth){
				maxdepth=depth;
			}
		}
		System.out.println(maxdepth);
	}
	
	public static void main(String[] args) {
		GenereicTreeImpl t = new GenereicTreeImpl();
		t.root = new GNode(1);
        t.root.firstChild = new GNode(2);
        t.root.firstChild.nextSibling = new GNode(3);
        t.root.firstChild.nextSibling.nextSibling= new GNode(4);
        t.root.firstChild.nextSibling.firstChild = new GNode(5);
        int[] p={-1,0,1,6,6,0,0,2,7};
        t.maxdepth(p);
	}
}
