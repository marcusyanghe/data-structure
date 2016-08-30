public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	//constructor with given grath and source node
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		DFS(G,s);         //
	}

  	//find out all the paths originating from node v being the source
	public void DFS(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(marked[w] = false) {
				edgeTo[w] = v;
				DFS(G,w);
			}
		}
	}

	//tell whether a path exist
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	//use a stack to store the path
	public Iterable<Integer> Path(int v) {
		if(!hasPathTo(v)) {
			return null;
		}
		Stack<Integer> path = new Stack<>();
		for(int i = v; i !=s; i = edgeTo(v)) {
			path.push(i);
		}
		path.push(s);
		return path;
	}
}