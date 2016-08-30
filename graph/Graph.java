/*
*this is a rough implementation of graph
**/

public class Graph {

	private final int V;    //# of vertices
	private int E;          //# of edges
	private Bag<Integer>[] adj;       // adjacent list which can also be implemented by other data structures; Bag is from Princeton Java Lib


	//constructor 
	public Graph (int vertex) {
		V = vertex;
		E = 0;
		adj = new Bag<Integer>[vertex];

		for(int i = 0; i<V; i++) {
			adj[i] = new Bag<Integer>();
		}
	} 

	//find our ajacent vertices
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}


	// add a edge
	public void addEdge(int n, int m) {
		adj[n].add(m);
		adj[m].add(n);
		E++;
	}
	//get num of Edges
	public int E() {
		return E;
	}

	//get num of vertices
	public int V() {
		return V;
	}
}




