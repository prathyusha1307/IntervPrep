package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class AdjList {

	int vertex;
	private LinkedList<Integer> adj[];
	
	public AdjList(int v) {
		this.vertex=v;
		adj= new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]= new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int i,int j){
		adj[i].add(j);
	}
	
	public void dfs(int v){
		boolean[] visited = new boolean[vertex];
		for (int i=0; i<vertex; ++i)
            if (visited[i] == false)
            	dfsUtil(i, visited);
	}

	private void dfsUtil(int v, boolean[] visited) {
		visited[v]=true;
		System.out.println(v);
		ListIterator<Integer> i=adj[v].listIterator();
		while(i.hasNext()){
			int n=i.next();
			if(!visited[n]){
				dfsUtil(n, visited);
			}	
		}
		
	}
	
	public void bfs(int v){
		boolean[] visited= new boolean[vertex];
		Queue<Integer> queue= new LinkedList<>();
		visited[v]=true;
		queue.add(v);
		while(!queue.isEmpty()){
			int n=queue.poll();
			System.out.println(n);
			Iterator<Integer> list=adj[n].listIterator();
			while(list.hasNext()){
				int n1=list.next();
				if(!visited[n1]){
					visited[n1]=true;
					queue.add(n1);
				}
			}
		}
	}
	
	public void topologicalSort(){
		boolean[] visited = new boolean[vertex];
		Stack<Integer> s= new Stack<Integer>();
		for(int i=0;i<vertex;i++){
			visited[i]=false;
		}
		for(int i=0;i<vertex;i++){
			if(visited[i]==false){
				topologicalSortUtil(i,s,visited);
			}
		}
		
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	private void topologicalSortUtil(int i, Stack<Integer> s, boolean[] visited) {
		visited[i]=true;
		Iterator<Integer> list= adj[i].listIterator();
		while(list.hasNext()){
			int t= list.next();
			if(!visited[t]){
				topologicalSortUtil(t, s, visited);
			}
		}
		s.push(i);
	}

	public static void main(String[] args) {
		AdjList g = new AdjList(4);
		 g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        //g.dfs(2);
	       // g.bfs(2);
	      //  g.topologicalSort();
	}
}
