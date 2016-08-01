public class IntList{
    
	int head;
    IntList tail;

    public IntList(int head, IntList tail){
        this.head = head;
        this.tail = tail;
    }
    
    public static void main(String[] args){
        IntList L = new IntList(5,null);
        L = new IntList(10,L);
        L = new IntList(15,L);

        System.out.println(L.head);
      //System.out.println(L.tail);
       // Size s = new Size();
        System.out.println(L.size());


    }
    

    //using recusion
    public int size(){
        if(tail == null){
            return 0;
        }
        return 1+tail.size();
 
    }

    // no recursion
    /*
    public int size(){
        IntList list = this;
        int i=0;
        while(true){
    	    if(list.tail==null){
    		    return i;
    	    }
    	    list = list.tail;
    	    i++;
        }
     }
     */

     //square intlist destructively using iteration
     public static IntList square1(IntList L){
     	IntList m = L;
     	while(m!= null){
     	 	m.head *= m.head;
     	 	m = m.tail;
     	}
     	 return L;
    }

    //square intlist destructively using recursion
	public static IntList square2(IntList L) {
		if(L == null) return null;
		else{
		L.head = L.head*L.head;
		L.tail = square2(L.tail);
		return L;
		}
	}
    //square intlist non-destructively using iteration  
	public static IntList square3(IntList L) {
		
		IntList aL = L;
		IntList M = new IntList(aL.head*aL.head, null);
		IntList aM = M;
		
		while(aL.tail != null){
			aM.tail = new IntList(aL.tail.head*aL.tail.head, null);
			aL = aL.tail;
			aM = aM.tail;
		}
		return M;
	}

    //square intlist non-destructively using recursion
    public static IntList square4(IntList L){
     	if(L == null) return null;
        IntList tail = square3(L.tail);
     	IntList m = new IntList(L.head*L.head,tail); 
     	return m;
    }
     
}

