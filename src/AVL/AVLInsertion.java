package AVL;

public class AVLInsertion {
	Node root;
	
	public int height(Node n){
		if(n==null){
			return 0;
		}return n.height;
	}
	
	public Node rightRotate(Node z){
		Node x=z.left;
		Node y=x.right;
		x.right=z;
		z.left=y;	
		z.height= Math.max(height(z.left), height(z.right))+1;		
		x.height= Math.max(height(x.left), height(x.right))+1;
		return x;
	}
	
	public Node leftRotate(Node z){
		Node x=z.right;
		Node l=x.left;
		x.left=z;
		z.right=l;
		z.height= Math.max(height(z.left), height(z.right))+1;		
		x.height= Math.max(height(x.left), height(x.right))+1;
		return x;
		
	}
	
	public int getBalance(Node n){
		if(n==null){
			return 0;
		}
		return height(n.left)-height(n.right);
	}
	
	public Node insert(Node n, int key){
		if(n==null){
			return new Node(key);
		}
		if(key<n.val){
			n.left=insert(n.left, key);
		}
		else if(key>n.val){
			n.right=insert(n.right, key);
		}else{
			return n;
		}
		n.height=Math.max(height(n.left), height(n.right))+1;
		
		int balance=getBalance(n);
		if(balance>1 && key<n.left.val){
			return rightRotate(n);
		}
		if(balance<-1 && key>n.right.val){
			return leftRotate(n);
		}
		if(balance>1 && key>n.left.val){
			n.left=leftRotate(n.left);
			return rightRotate(n);
		}
		if(balance<-1 && key<n.right.val){
			n.right=rightRotate(n.right);
			return leftRotate(n);
		}
		return n;
	}
	void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
	
	public Node deletion(Node root, int key){
		if(root==null){
			return root;
		}
		if(root.val>key){
			root.left=deletion(root.left,key);
		}
		else if(root.val<key){
			root.right=deletion(root.right,key);
		}else{
			if((root.left==null || root.right==null)){
				Node temp=null;
				if(temp==root.left){
					temp=root.right;
				}else{
					temp=root.left;
				}
				if(temp==null){
					root=null;
				}else{
					root=temp;
				}
			}else{
				Node t=minValue(root.right);
				root.val=t.val;
				root.right=deletion(root.right,t.val);
			}
		}
		if(root==null){
			return root;
		}
		
		root.height=Math.max(height(root.left), height(root.right))+1;
		
		int balance=getBalance(root);
		if(balance>1 && getBalance(root.left)>=0){
			return rightRotate(root);
		}
		if(balance>1 && getBalance(root.left)<0){
			root.left=leftRotate(root.left);
			return rightRotate(root);
		}
		if(balance<-1 && getBalance(root.right)<=0){
			return leftRotate(root);
		}
		if(balance<-1 && getBalance(root.right)>0){
			root.right=rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}
	private Node minValue(Node n) {
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}

	public static void main(String[] args) {
		 AVLInsertion tree = new AVLInsertion();
	       tree.root = tree.insert(tree.root, 9);
	        tree.root = tree.insert(tree.root, 5);
	        tree.root = tree.insert(tree.root, 10);
	        tree.root = tree.insert(tree.root, 0);
	        tree.root = tree.insert(tree.root, 6);
	        tree.root = tree.insert(tree.root, 11);
	        tree.root = tree.insert(tree.root, -1);
	        tree.root = tree.insert(tree.root, 1);
	        tree.root = tree.insert(tree.root, 2);
	        tree.preOrder(tree.root);
	        tree.root=tree.deletion(tree.root, 10);
	        System.out.println("ooo");
	        tree.preOrder(tree.root);
	}
 
}
