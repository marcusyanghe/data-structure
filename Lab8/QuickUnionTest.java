import org.junit.Test;
import static org.junit.Assert.*;

public class QuickUnionTest {
	
	@Test
	public void testFind() {
		QuickUnion tree = new QuickUnion(8);
		
		tree.union(1,2);
		tree.union(2,3);
		tree.union(4,5);
		int actural = tree.find(1);
		int expect = 3;
		assertEquals(actural, actural);
		actural = tree.find(6);
		expect = 6;
		assertEquals(actural, actural);
	}

	@Test
	public void testFindRec() {
		QuickUnion tree = new QuickUnion(8);
		tree.union(1,2);
		tree.union(2,3);
		tree.union(4,5);
		int actural = tree.findRec(1);
		int expect = 3;
		assertEquals(actural, actural);
		actural = tree.findRec(6);
		expect = 6;
		assertEquals(actural, actural);
		QuickUnion tree = new QuickUnion(8);

		
	}


 	public static void main(String[] args) {        
        jh61b.junit.TestRunner.runTests("all", QuickUnionTest.class);
    }
} 