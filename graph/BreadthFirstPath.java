public class BreadFirstPaths {
	private boolean[] marked;
	private int[] toEdge;
	private int s;

	public BreadFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		toEdge = new int[G.V()];
		this.s = s;
		BFS(G,s);
	}

	public BFS(Graph G, int v) {
		Queue<Integer> queue = new Queue<>();
		marked[v] = true;
		queue.enqueue(v);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : g.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue();
				}
			}
		}
	}

}