package Graphs;

public class AdjMatrix {

	boolean[][] adjMatrix;
	int vertexcount;
	
	AdjMatrix(int v){
		this.vertexcount=v;
		adjMatrix= new boolean[vertexcount][vertexcount];
	}
	public void addEdge(int i, int j){
		if((i>=0 && i<vertexcount)&& (j>=0 && j<vertexcount) ){
			adjMatrix[i][j]=true;
			adjMatrix[j][i]=true;
		}
	}
	
	public void removeEdge(int i, int j){
		if((i>=0 && i<vertexcount)&& (j>=0 && j<vertexcount) ){
			adjMatrix[i][j]=false;
			adjMatrix[j][i]=false;
		}
	}
	
	public boolean isEdge(int i, int j){
		if((i>=0 && i<vertexcount)&& (j>=0 && j<vertexcount) ){
			return adjMatrix[i][j];
		}
		return false;
	}
}
