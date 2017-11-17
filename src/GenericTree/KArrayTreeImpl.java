package GenericTree;

public class KArrayTreeImpl {

	int ind=0;
	KNode buildTree(int[] A, int n, int k){
		KNode root= new KNode(k);
		root.data=A[ind];
		for(int i=0;i<k;i++){
			if(k*ind+i<n){
				ind++;
				root.setChild(ind, buildTree(A,n,k));
				
			}
		}
		return root;
	}
	public static void main(String[] args) {
		KArrayTreeImpl t= new KArrayTreeImpl();
		int[] A={1,2,3,4,5,6,7};
		t.buildTree(A, A.length, 2);
	}
}

class KNode{
	KNode[] child;
	int data;
	public   KNode(int k){
		child = new KNode[k];
		this.data=data;
	}
	
	public void setChild(int i, KNode childnode){
		child[i]=childnode;
	}

}