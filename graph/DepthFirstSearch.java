public class DepthFirstSearch {
	private boolean[] marked;
	private int count;


	public DepthFirstSearch(Graph G, V v) {
		marked =  new boolean[G.V()];
		DFS(G,v);		
	}

	public boolean marked(int v) {
		return marked[v];

	} 

	public void DFS(Graph G, int v) {
		marked[v] = true;
		count++;
		for(int i : G.adj()) {
			if(marked[i] = false) {
				DFS(G, i);
			}
		}
	}

	public int count() {
		return count;
	}
}