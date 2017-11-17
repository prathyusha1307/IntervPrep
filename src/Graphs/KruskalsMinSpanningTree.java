//package Graphs;
//
//import java.util.Arrays;
//
//public class KruskalsMinSpanningTree {
//
//	class Graph{
//		int V;
//		int E;
//		Edge[] edge;
//		Graph(int v, int e){
//			this.V=v;
//			this.E=e;
//			edge= new Edge[e];
//			for(int i=0;i<e;i++){
//				edge[i]= new Edge();
//			}
//		}
//		class Edge implements Comparable<Edge>
//		{
//			int src, dest, weight;
//
//			// Comparator function used for sorting edges 
//			// based on their weight
//			public int compareTo(Edge compareEdge)
//			{
//				return this.weight-compareEdge.weight;
//			}
//		};
//	}
//
//	class Subset{
//		int parent;
//		int rank;
//	};
//	int find(Subset[] subset, int i){
//		if(subset[i].parent!=i){
//			subset[i].parent=find(subset, subset[i].parent);
//		}
//		return subset[i].parent;
//	}
//	
//	public void union(Subset[] subset, int x, int y){
//		int xroot=find(subset, x);
//		int yroot=find(subset,y);
//		if(subset[xroot].rank>subset[yroot].rank){
//			subset[yroot].parent=xroot;
//		}
//		else if(subset[yroot].rank>subset[xroot].rank){
//			subset[xroot].parent=yroot;
//		}else{
//			subset[xroot].rank++;
//			subset[xroot].rank=yroot;
//		}
//				
//	}
//	 void KruskalMST(Graph graph)
//	    {
//	        Edge result[] = new Edge[graph.V];  // Tnis will store the resultant MST
//	        int e = 0;  // An index variable, used for result[]
//	        int i = 0;  // An index variable, used for sorted edges
//	        for (i=0; i<graph.V; ++i)
//	            result[i] = new Edge();
//	 
//	        // Step 1:  Sort all the edges in non-decreasing order of their
//	        // weight.  If we are not allowed to change the given graph, we
//	        // can create a copy of array of edges
//	        Arrays.sort(graph.edge);
//	 
//	        // Allocate memory for creating V ssubsets
//	        Subset subsets[] = new Subset[graph.V];
//	        for(i=0; i<graph.V; ++i)
//	            subsets[i]=new Subset();
//	 
//	        // Create V subsets with single elements
//	        for (int v = 0; v < graph.V; ++v)
//	        {
//	            subsets[v].parent = v;
//	            subsets[v].rank = 0;
//	        }
//	 
//	        i = 0;  // Index used to pick next edge
//	 
//	        // Number of edges to be taken is equal to V-1
//	        while (e < graph.V - 1)
//	        {
//	            // Step 2: Pick the smallest edge. And increment 
//	            // the index for next iteration
//	            Graphs.Edge next_edge = new Edge();
//	            next_edge =edge[i++];
//	 
//	            int x = find(subsets, next_edge.src);
//	            int y = find(subsets, next_edge.dest);
//	 
//	            // If including this edge does't cause cycle,
//	            // include it in result and increment the index 
//	            // of result for next edge
//	            if (x != y)
//	            {
//	                result[e++] = next_edge;
//	                union(subsets, x, y);
//	            }
//	            // Else discard the next_edge
//	        }
//	 
//	        // print the contents of result[] to display
//	        // the built MST
//	        System.out.println("Following are the edges in " + 
//	                                     "the constructed MST");
//	        for (i = 0; i < e; ++i)
//	            System.out.println(result[i].src+" -- " + 
//	                   result[i].dest+" == " + result[i].weight);
//	    }
//}
//
