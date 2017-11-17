package Graphs;

public class Graph {
	Edge[] edj;
	int V;
	int E;
	public Graph(int v, int e) {
		this.V=v;
		this.E=e;
		 edj = new Edge[e];
	        for (int i=0; i<e; ++i)
	            edj[i] = new Edge();
	}
	
	public void belmanfordAlgo(Graph graph,int src) throws Exception{
		int[] dist= new int[V];
		for(int i=0;i<V;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[src]=0;
		
		for(int i=0;i<V-1;i++){
			for(int j=0;j<E;j++){
				int u=graph.edj[j].src;
				int v=graph.edj[j].dest;
				int weight=graph.edj[j].weight;
				if(dist[u]!=Integer.MAX_VALUE && (dist[v]>dist[u]+weight)){
					dist[v]=dist[u]+weight;
				}
			}
		}
		
		for(int j=0;j<E;j++){
			int u=graph.edj[j].src;
			int v=graph.edj[j].dest;
			int weight=graph.edj[j].weight;
			if(dist[u]!=Integer.MAX_VALUE && (dist[v]>dist[u]+weight)){
				throw new Exception("cycle");
			}
		}
		 printArr(dist, V);
	}
	 void printArr(int dist[], int V)
	    {
	        System.out.println("Vertex   Distance from Source");
	        for (int i=0; i<V; ++i)
	            System.out.println(i+"\t\t"+dist[i]);
	    }

	public static void main(String[] args) throws Exception {
		 int V = 5;  // Number of vertices in graph
	        int E = 8;  // Number of edjs in graph
	 
	        Graph graph = new Graph(V, E);
	 
	        // add edj 0-1 (or A-B in above figure)
	        graph.edj[0].src = 0;
	        graph.edj[0].dest = 1;
	        graph.edj[0].weight = -1;
	 
	        // add edj 0-2 (or A-C in above figure)
	        graph.edj[1].src = 0;
	        graph.edj[1].dest = 2;
	        graph.edj[1].weight = 4;
	 
	        // add edj 1-2 (or B-C in above figure)
	        graph.edj[2].src = 1;
	        graph.edj[2].dest = 2;
	        graph.edj[2].weight = 3;
	 
	        // add edj 1-3 (or B-D in above figure)
	        graph.edj[3].src = 1;
	        graph.edj[3].dest = 3;
	        graph.edj[3].weight = 2;
	 
	        // add edj 1-4 (or A-E in above figure)
	        graph.edj[4].src = 1;
	        graph.edj[4].dest = 4;
	        graph.edj[4].weight = 2;
	 
	        // add edj 3-2 (or D-C in above figure)
	        graph.edj[5].src = 3;
	        graph.edj[5].dest = 2;
	        graph.edj[5].weight = 5;
	 
	        // add edj 3-1 (or D-B in above figure)
	        graph.edj[6].src = 3;
	        graph.edj[6].dest = 1;
	        graph.edj[6].weight = 1;
	 
	        // add edj 4-3 (or E-D in above figure)
	        graph.edj[7].src = 4;
	        graph.edj[7].dest = 3;
	        graph.edj[7].weight = -3;
	 
	        graph.belmanfordAlgo(graph, 0);
	}
}

class Edge{
	int src;
	int dest;
	int weight;
	Edge(){
		this.src=0;
		this.dest=0;
		this.weight=0;
	}
}