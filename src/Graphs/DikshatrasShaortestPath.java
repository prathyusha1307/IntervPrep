package Graphs;

public class DikshatrasShaortestPath {

	int vertex;
	public DikshatrasShaortestPath(int v) {
		this.vertex=v;
	}
	public void shortPath(int s,int[][] graph){
		int[] dist= new int[vertex];
		boolean[] visited= new boolean[vertex];
		for(int i=0;i<vertex;i++){
			dist[i]=-1;
			visited[i]=false;
		}
		dist[s]=0;
		
		for(int i=0;i<vertex;i++){
			int u=getMin(dist,visited);
			visited[u]=true;
			for(int v=0;v<vertex;v++){
				if(!visited[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && (dist[v]>dist[u]+graph[u][v])){
					dist[v]=dist[u]+graph[u][v];
				}
			}
				
		}
		printSolution(dist, vertex);
	}
	
	 // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < vertex; i++)
            System.out.println(i+" tt "+dist[i]);
    }
 
	private int getMin(int[] dist,boolean[] visited) {
	
		int min=Integer.MAX_VALUE;
		int v=0;
		for(int i=0;i<vertex;i++){
			if(!visited[i] && min>dist[i]){
				min=dist[i];
				v=i;
			}
		}
		return v;
	}
	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
DikshatrasShaortestPath t = new DikshatrasShaortestPath(11);
t.shortPath(0, graph);
}
}
