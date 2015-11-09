import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigDecimal;

public class ArithmeticExpressionTreeTest {

	@Test
	public void test1() {
		String expr = "((1+2)+3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(myTree.eval(), new BigDecimal(6.0));
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
		
	}

	@Test
	public void test2() {
		String expr = "((1+2)*3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(myTree.eval(), new BigDecimal(9.0));
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
		
	}
	
	@Test
	public void test3() {
		String expr = "((1+2)/3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(myTree.eval(), new BigDecimal(1.0));
		}
		catch( Exception e ) {
			fail("Exception!");
		}
		
	}
	
	@Test
    public void test4() {
        String expr = "((1+2)/0)";
        ArithmeticExpressionTree myTree;
        try {
            myTree = new ArithmeticExpressionTree(expr);
           myTree.eval();
        }
        catch( Exception e ) {
            assert true;
        }
       
    }
	

    @Test
    public void test5() {
        String expr = "((1+2)^(1/2))";
        ArithmeticExpressionTree myTree;
        try {
            myTree = new ArithmeticExpressionTree(expr);
            myTree.eval();
        }
        catch( Exception e ) {
            assert true;
        }
        
    }
    
    @Test
    public void test6() {
        String expr = "((1+2)^(2))";
        ArithmeticExpressionTree myTree;
        try {
            myTree = new ArithmeticExpressionTree(expr);
            assertEquals(myTree.eval(), new BigDecimal(9.0));
        }
        catch( Exception e ) {
            fail("Exception!");
        }
        
    }
}
