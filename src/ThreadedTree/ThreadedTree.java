package ThreadedTree;

public class ThreadedTree {

	public ThreadedNode inorderSuccessor(ThreadedNode p){
		ThreadedNode temp;
		if(p.RTag==0){
			return p.right;
		}else{
			temp=p.right;
			while(temp.LTag==1){
				temp=temp.left;
			}
			return temp;
		}
	}
	
	public static void main(String[] args) {
		
	}
}

class ThreadedNode{
	ThreadedNode left;
	ThreadedNode right;
	int LTag;
	int RTag;
	int data;
	ThreadedNode(){
		left=right=null;
		LTag=RTag=data=0;
	}
}