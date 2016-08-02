
public class Test extends IntList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        IntList m = IntList.list(1, 2, 3);
        IntList n = IntList.list(4, 5, 6);

        System.out.println(m);
        System.out.println(n);
        System.out.println(IntList.catenate(m, n));
        //System.out.println(m);
        


	}

}
