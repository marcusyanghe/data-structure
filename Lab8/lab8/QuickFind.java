public class QuickFind {
	private int[] id;
	private int count;

	public QuickFind(int n) {
		id = new int[n];
		for(int i=0; i<n;i++) {
			id[i] = i;
			count++;
		}
	} 

	public int count() {
		return count;
	}

	public int find (int p) {
		valid(p);
		return id[p];	
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
 		return id[p] == id[q];
 			
 	}

 	public void union(int p, int q) {
 		//valid(p);
 		//valid(q);
 		if (connected(p,q)) {
 			return;
 		}

 		int i = 0;
 		while (i<id.length) {
 			if(id[i] == find(p)) {
 				id[i] = find(q); 
 			}
 			i++;
 		}
 	}

 	 public static void main(String[] args) {
 		int n = StdIn.readInt();
 		QuickFind qf = new QuickFind(n);
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