package Tree;

import java.util.Stack;

public class BinarySearchTree {

	static Node root;

	public void insert(int val){
		if(root==null){
			root= new Node(val);
		}else{
			insert(root,val);
		}
	}

	private Node insert(Node root, int val) {
		if(root==null){
			root= new Node(val);
		}else{
			if(root.val>val){
				root.left=insert(root.left, val);
			}else{
				root.right=insert(root.right, val);
			}
		}
		return root;		
	}

	public boolean findVal(Node root,Node p){
		if(root==null){
			return false;
		}
		if(root.val==p.val){
			return true;
		}
		if(root.val>p.val){
			return findVal(root.left,p);
		}
		if(root.val<p.val){
			return findVal(root.right, p);
		}
		return false;
	}


	public Node findMin(Node root){
		Node temp=root;
		if(root==null){
			return null;
		}
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp;
	}

	public Node findMax(){
		Node temp=root;
		if(root==null){
			return null;
		}
		while(temp.right!=null){
			temp=temp.right;
		}
		return temp;
	}

	public Node delete(Node root, Node p){
		if(root==null){
			return root;
		}
		if(root.val<p.val){
			root.right=delete(root.right,p);
		}
		else if(root.val>p.val){
			root.left=delete(root.left,p);
		}else{
			if(root.left==null){
				return root.right;
			}
			else if(root.right==null){
				return root.left;
			}

			root.val=findMin(root.right).val;
			root.right=delete(root.right, p);

		}
		return root;
	}

	public int distanceFromRoot(Node root, int x){
		if(root.val==x){
			return 1;
		}
		else if(root.val<x){
			return 1+distanceFromRoot(root.left, x);
		}
		else{
			return 1+distanceFromRoot(root.right, x);		
		}
	}

	public int minDistance(Node root, Node a, Node b){
		if(root==null){
			return 0;
		}
		if(root.val< a.val && root.val<b.val){
			return minDistance(root.right, a, b);
		}
		if(root.val> a.val && root.val>b.val){
			return minDistance(root.left, a, b);
		}
		if((root.val>=a.val && root.val<=b.val) || (root.val<=a.val && root.val>=b.val)){
			return distanceFromRoot(root.left, a.val)+distanceFromRoot(root.right, b.val);
		}
		return 0;
	}
	
	
	public Node convertBSTToDLL(Node root){
		if(root==null){
			return root;
		}
		Node t=convBST_DLL(root);
		while(t.left!=null){
			t=t.left;
		}
		return t;
	}

	private Node convBST_DLL(Node root) {
		if(root==null){
			return root;
		}
		if(root.left!=null){
			Node t=convBST_DLL(root.left);
			for(;t.right!=null;t=t.right){
				
			}
			t.right=root;
			root.left=t;
		}
		if(root.right!=null){
			Node t=convBST_DLL(root.right);
			for(;t.left!=null;t=t.left){
				
			}
			t.left=root;
			root.right=t;
		}
		return root;
	}

	public Node findLCA(Node root, Node a, Node b){
		if(root.val==a.val || root.val==b.val){
			return root;
		}
		Node left=findLCA(root.left, a, b);
		Node right=findLCA(root.right, a, b);
		if(left!=null && right!=null){
			return root;
		}
		return left!=null?left:right;
	}
	
	public boolean isBST(Node root, int min, int max){
		if(root.val<min || root.val>max){
			return false;
		}
		return isBST(root.left,min,root.val) && isBST(root.right,root.val,max); 
	}
	
	public Node constructBSTfromArray(int[] arr, int start, int end){
		if(start>end){
			return null;
		}
		int mid=(start+end)/2;
		Node root= new Node(arr[mid]);
		root.left=constructBSTfromArray(arr, start, mid-1);
		root.right=constructBSTfromArray(arr, mid+1, end);
		return root;
	}
	
	public void findKthSmallestElem(int k){
		Node p=root;
		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty() || p!=null){
			if(p!=null){
				s.push(p);
				p=p.left;
			}else{
				Node t=s.pop();
				k--;
				if(k==0){
					System.out.println(t.val);
					break;
				}
				p=t.right;
			}
		}
	}
	int ceil=0;
	public int floorCeil(Node root, int input){
		if(root==null){
			return -1;
		}
		if(root.val==input){
			return root.val;
		}
		if(root.val<input){
			ceil =floorCeil(root.right, input);
		}else{
			ceil=floorCeil(root.left, input);
		}
		return ceil>=input?ceil:root.val;
	}
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		root = tree.insert(root, 20);
		root = tree.insert(root, 8);
		root = tree.insert(root, 22);
		root = tree.insert(root, 4);
		root = tree.insert(root, 12);
		root = tree.insert(root, 10);
		root = tree.insert(root, 14);
		//System.out.println(tree.findVal(root, new Node(19)));
		//System.out.println(tree.findMax().val);
		//System.out.println(tree.minDistance(root, new Node(8), new Node(22)));
		//tree.findKthSmallestElem(4);
		
		System.out.println(tree.floorCeil(root, 11));
	}
}
