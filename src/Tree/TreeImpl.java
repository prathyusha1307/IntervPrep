package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeImpl {

	Node root;
	Node prev;
	Node next;
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
			if(root.val<val){
				root.right=insert(root.right,val);
			}else{
				root.left=insert(root.left,val);
			}
		}
		return root;		
	}
	
	
	public Node convertBT_DLL(Node head){
		if(head==null){
			return head;
		}
		if(head.left!=null){
			Node n=convertBT_DLL(head.left);
			while(n.right!=null){
				n=n.right;
			}
			n.right=head;
			head.left=n;
		}
		
		if(head.right!=null){
			Node n=convertBT_DLL(head.right);
			while(n.left!=null){
				n=n.left;
			}
			n.left=head;
			head.right=n;
		}
		return head;
	}
	
	
	public int findMaxElem(Node root){
		if(root==null){
			return Integer.MIN_VALUE;
		}
		int n=root.val;
		int leftMax=findMaxElem(root.left);
		int rightMax=findMaxElem(root.right);
		if(leftMax>rightMax){
			n=leftMax;
		}else{
			n=rightMax;
		}
		return n;
	}
	void printList(Node node) 
    {
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
	
	public Node convBT_DLL(Node n){
		if(n==null){
			return n;
		}
		Node n1=convertBT_DLL(n);
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}
  
	public void preorder(Node root){
		if(root!=null){
			System.out.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void preorder_recursive(Node root){
		List<Integer> res= new ArrayList<Integer>();
		Stack<Node> s = new Stack<Node>();
		
		s.push(root);
		while(!s.isEmpty()){
			Node temp=s.pop();
			res.add(temp.val);
			if(temp.right!=null){
				s.push(temp.right);
			}
			if(temp.left!=null){
				s.push(temp.left);
			}
		}
		
		System.out.println(res.toString());
	}
	
	public void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}
	
	public void inorder_recursive(Node root){
		List<Integer> res= new ArrayList<Integer>();
		Stack<Node> s = new Stack<Node>();
		boolean flag=false;
		Node newnode=root;
		while(!flag){
			if(newnode!=null){
				s.push(newnode);
				newnode=newnode.left;
			}else{
				if(s.isEmpty()){
					flag=true;
				}else{
					Node temp=s.pop();
					res.add(temp.val);
					newnode=temp.right;
				}
			}
		}
		System.out.println(res.toString());
	}
	
	public void levelOrderTraversal(Node root){
		ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
		Queue<Node> q= new LinkedList<Node>();
		List<Integer> arr= new ArrayList<Integer>();
		q.add(root);
		arr.add(root.val);
		res.add((ArrayList<Integer>) arr);
		while(!q.isEmpty()){
			arr= new ArrayList<Integer>(); 
			Node temp=q.poll();
				if(temp.left!=null){
					arr.add(temp.left.val);
					q.add(temp.left);
				}
				if(temp.right!=null){
					arr.add(temp.right.val);
					q.add(temp.right);
				}
			
				res.add((ArrayList<Integer>) arr);
			
		}
		System.out.println(res.toString());
	}
	
	public void findMaxElemWithoutRecursion(Node root){
		int max=Integer.MIN_VALUE;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null && max<temp.val ){
				max=temp.val;
			}
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
		System.out.println(max);
	}
	
	public boolean findElemInBT(Node root, int val){
		if(root==null){
			return false;
		}
		if(root.val==val){
			return true;
		}
		return findElemInBT(root.left, val) || findElemInBT(root.right, val);
	}
	
	public void findElemInBTWithoutRecurssion(Node root, int val){
		boolean flag=true;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(temp!=null && temp.val==val ){
				flag=true;
				break;
			}
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
		System.out.println(flag);
	}
	
	public int findSize(Node root){
		if(root==null){
			return 0;
		}
		return 1+findSize(root.left)+findSize(root.right);
	}
	
	public void findLevelMaxSumOfBT(Node root){
		int max=0;
		int sum=0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp=q.poll();
				if(sum>=max){
					max=sum;
				}
				sum=0;				
				if(temp.left!=null){
					q.add(temp.left);
					sum=sum+temp.left.val;
				}
				if(temp.right!=null){
					q.add(temp.right);
					sum=sum+temp.right.val;
				}
		}
		System.out.println(max);
	}
	
	public void printRootLeafPath(Node root,int[] path, int i){
		if(root==null){
			return;
		}
		path[i]=root.val;
		i++;
		if(root.left==null && root.right==null){
			printArray(path,i);
		}else{
			printRootLeafPath(root.left, path,i);
			printRootLeafPath(root.right, path,i);
		}
	}
	
	private void printArray(int[] path,int i) {
		for(int k=0;k<i;k++){
			System.out.println(path[k]);
		}
		
	}
	int preindex=0;
	public Node buildTree(int[] inorder, int[] preorder, int instart, int inend){
		if(instart>inend){
			return null;
		}
		
		Node temp= new Node(preorder[preindex]);
		preindex++;
		if(instart==inend){
			return temp;
		}
		int index=search(inorder,instart,inend,temp.val);
		temp.left=buildTree(inorder, preorder, instart, index-1);
		temp.right=buildTree(inorder, preorder, index+1, inend);
		return temp;
	}
	
	
	public Node buildTree(int[] inorder, int[] postorder, int instart, int inend, int postindex){
		if(instart>inend || postindex<0){
			return null;
		}
		
		Node temp= new Node(postorder[postindex]);
		postindex--;
		
		if(instart==inend){
			return temp;
		}
		
		int index= search(inorder, instart, inend, temp.val);
		
		temp.left=buildTree(inorder, postorder, instart, index-1,postindex);
		temp.right=buildTree(inorder, postorder, index+1, inend,postindex);
		
		return temp;
		
	}
	
	private int search(int[] inorder, int instart, int inend, int val) {
		for(int k=instart;k<inend;k++){
			if(inorder[k]==val){
				return k;
			}
		}
		return 0;
	}
	
	public boolean printAncestors(Node root, int target){
		if(root==null){
			return false;
		}
		if(root.val==target){
			return true;
		}
		
		if(printAncestors(root.left, target) || printAncestors(root.right, target)){
			System.out.println(root.val);
			return true;
		}
		return false;
		
	}
	
	public Node LCA(Node root, int n1, int n2){
		if(root==null){
			return null;
		}
		if(root.val ==n1 || root.val==n2){
			return root;
		}
		Node left=LCA(root.left,n1,n2);
		Node right=LCA(root.right,n1,n2);
		if(left!=null && right!=null){
			return root;
		}
		return left!=null?left:right;
	}
	
	
	public int height(Node root){
		if(root==null){
			return 0;
		}
		int left=height(root.left);
		int right=height(root.right);
		return Math.max(left, right)+1;
	}
	
	public void printSpiral(Node root){
		boolean flag=false;
		for(int i=1;i<=height(root);i++){
			printSpiralTree(root,i,flag);
			flag=!flag;
		}
	}
	private void printSpiralTree(Node root, int level, boolean flag) {
		if(root==null){
			return;
		}
		if(level==1){
			System.out.println(root.val);
		}else{
			if(flag){
				printSpiralTree(root.left, level-1, flag);
				printSpiralTree(root.right, level-1, flag);
			}else{
				printSpiralTree(root.right, level-1, flag);
				printSpiralTree(root.left, level-1, flag);
			}
		}
	}
	
	public void spiralUsingStacks(Node root){
		Stack<Node> s1= new Stack<Node>();
		Stack<Node> s2= new Stack<Node>();
		s1.push(root);
		while(s1.isEmpty() || s2.isEmpty()){
			
			while(!s1.isEmpty()){
				Node temp=s1.peek();
				System.out.println(temp.val);
				s1.pop();
				if(temp.right!=null){
					s2.add(temp.right);
				}
				if(temp.left!=null){
					s2.add(temp.left);
				}
			}
			
			while(!s2.isEmpty()){
				Node temp=s2.peek();
				System.out.println(temp.val);
				s2.pop();
				if(temp.left!=null){
					s2.add(temp.left);
				}
				if(temp.right!=null){
					s2.add(temp.right);
				}
			}
		}
	}
	
	public void verticalSum(Node root){
		Map<Integer, Integer> hm= new HashMap<Integer,Integer>();
		verticalSumOfNode(root,0,hm);
		
		if(hm!=null){
			System.out.println(hm.entrySet());
		}
	}
	private void verticalSumOfNode(Node root, int hd, Map<Integer, Integer> hm) {
		if(root==null){
			return;
		}
		verticalSumOfNode(root.left, hd-1, hm);
		int left=hm.get(hd)!=0?hm.get(hd):0;
		hm.put(hd,left+root.val );
		verticalSumOfNode(root.right, hd, hm);
	}
	
	public List<Node> generateTrees(int start, int end){
		List<Node> list = new ArrayList<Node>();
		if(start>end){
			return list;
		}
		for(int i=start;i<=end;i++){
			for(Node left: generateTrees(start, i-1)){
				for(Node right: generateTrees(i+1, end)){
					Node root= new Node(i);
					root.left=left;
					root.right=right;
					list.add(root);
				}
			}
		}
		return list;
		
	}
	
	public Node buildTreeForStringInput(char[] c, int i){
		if(c.length==i){
			return null;
		}
		Node root= new Node(c[i]);
		root.left=null;
		root.right=null;
		if(c[i]=='L'){
			return root;
		}
		else{
			i++;
			root.left=buildTreeForStringInput(c, i);
			i++;
			root.right=buildTreeForStringInput(c, i);
		}
		return root;
	}
	
	public void rightSibling(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node t=q.poll();
			t.rightsibling=q.peek();
			if(t.left!=null){
				q.add(t.left);
			}
			if(t.right!=null){
				q.add(t.right);
			}
		}
	}
	
	public Node inorderSuccessor(Node root, Node p){
		if(root==null)
        return null;
 
    Node next = null;
    Node c = root;
    while(c!=null && c.val!=p.val){
        if(c.val > p.val){
            next = c;
            c = c.left;
        }else{
            c= c.right;
        }
    }
 
    if(c==null)        
        return null;
 
    if(c.right==null)
        return next;
 
    c = c.right;
    while(c.left!=null)
        c = c.left;
 
    return c;
    }
	public Node preorderSuccessor(Node root, Node p){
		if(root==null || (root.left==null || root.right==null )){
			return null;
		}
		Node temp=root;
		Node anc=null;
		while(temp!=null && temp.val!=p.val){
			if(p.val<temp.val){
				if(temp.right!=null){
					anc=temp;
				}
				temp=temp.left;
			}else{
				temp=temp.right;
			}
		}
		if(temp.left!=null){
			return temp.left;
		}
		if(temp.right!=null){
			return temp.right;
		}
		if(anc!=null){
			return anc.right;
		}
		return null;
	}
	
	public static void main(String[] args) {
		TreeImpl tree = new TreeImpl();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        System.out.println(tree.preorderSuccessor(root, new Node(14)).val);
	}
}
