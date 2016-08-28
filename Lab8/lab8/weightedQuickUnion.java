public class weightedQuickUnion {
	private int[] id;
	private int count;
	private int[] size;
	public weightedQuickUnion(int n) {
		id = new int[n];
		size = new int[n];
		count = id.length;

		for(int i=0; i<n;i++) {
			id[i] = i;
			size[i] = 1;
		}

	} 

	public int count() {
		return count;
	} 
	/* find the root of a tree
	* implement iteratively
	**/
	public int find (int p) {
		valid(p);
		/*
		if(id[p] == p) {
			return p;
		}
		int val = id[p];
		while(val != id[val]) {
			val = id[val];
		}
		return val;
		*/

		while(p != id[p]) {
			p = id[p];
		}
		return p;
	}


	//implement recursively
	public int findRec (int p) {
		valid(p);
		if(p == id[p]) {
			return p;
		}
		p = id[p];
		return findRec(p);
	}
	

	private void valid(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }

 	public boolean connected(int p, int q) {
 		valid(p);
 		valid(q);
 		return find(p) == find(q);
 	}

 	
 	public void union(int p, int q) {
 		valid(p);
 		valid(q);
 		if (connected(p,q)) {
 			return;
 		}
 		//if the size of p is smaller or equal to q,put p on q
 		if(size[p]<=size[q]) {
 			id[find(p)] = find(q);
 		} else {
 			id[find(q)] = find(p);
 		}

 		size[p] += size[q];
 		size[q] += size[p];
 	}

 	public static void main(String[] args) {
 		int n = StdIn.readInt();
 		weightedQuickUnion qf = new weightedQuickUnion(n);
 		while(!StdIn.isEmpty()) {
 			int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qf.connected(p, q)) {
				StdOut.println(p+" and "+q +" have been connected before");
				continue;

            }
            
            qf.union(p,q) ;
            StdOut.println("you just input: "+p+" , "+q);

            StdOut.println("you have connected "+p+" and "+q);
 		}
 		StdOut.println(qf.count() + " components");
 	}
} 