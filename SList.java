class SList{

	private class SNode{
		public int item; // inner class public ????
		public SNode next;
		public SNode(int item, SNode next){
			this.item = item;
			this.next = next;
		}
	}
	private SNode front;
	public void insertFront(int item){
		front = new SNode(item, front);
	}

	public void show(){
		SNode cur = front;
		while(cur !=null){
		System.out.println(cur.item);
		cur = cur.next;
		}
	}

	public void insert(int item, int position){
		SNode cur = front;
		int counter = 0;

		if(position == 0){
			//front = new SNode(item, cur);
			insertFront(item);
			return;
		}


		while(counter < position-1 && cur.next !=null){
			cur = cur.next;
			counter++;
		}
		cur.next = new SNode(item,cur.next);
		//return;
	}


	//reverse the list using iteration,O(n)
    public void reverse(){
    	SNode start = null;
    	SNode cur =front;
    	//SNode tmp =cur;
    	while( cur!= null){
    		SNode tmp = cur.next;
    		cur.next = start;
    		start = cur;
    		cur = tmp;
    	}
    	front = start;

    }
    
    //reverse the list using iteration,O(n^2)
    public void reverse1(){
    	SNode start = front;
    	SNode cur =start;
    	SNode end =start;
        int index = 0;

        if(start == null) return;

    	while(start.next != null ){
    	 	cur = start;
    		while(cur.next != null){
  				end = cur;
    			cur = cur.next;
    		}
    		insert(cur.item,index);
        	end.next = null;
        	index++;
    	}
    }

    //reverse the list using recursion
    // helper method
    private SNode reverseHelper(SNode front){
    	if(front == null | front.next == null){
    		return front;
    	}else{
    		SNode reversed = reverseHelper(front.next);
    		front.next.next = front;
    		front.next = null;
    		return reversed;
    	}

    }
    public  void reverse2(){
    	front = reverseHelper(front);
    }


}

//for the test
class test{
	public static void main(String args[]){
		SList s = new SList();
		s.insertFront(4);
		s.insertFront(3);
		s.insertFront(2);
		s.insertFront(1);
		//s.insert(100,6);
		//s.reverse();
		s.reverse();
		s.show();
	}
}