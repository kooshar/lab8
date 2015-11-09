import java.math.BigDecimal;

public class DivideNode extends Node {

    /**
     * Create a new node that represents a division operation. The two children
     * of this node represent the two operands, although they may be
     * subexpressions that need to be evaluated.
     * 
     * @param leftNode
     * @param rightNode 
     * @throws MalformedExpressionException  if the rightnode is zero
     * @requires rightNodes evaluation should not be zero
     */
    public DivideNode(Node leftNode, Node rightNode) throws MalformedExpressionException {
        super(leftNode, rightNode);
        
        if(rightNode.evaluate().compareTo(BigDecimal.ZERO)==0){
            throw new MalformedExpressionException("division byzero not supported");
        }
    }

    /**
     * Evaluate the division operation by evaluating the two child nodes and
     * then dividing their results.
     *
     * @return the sum of the left and right subtrees
     */
    public BigDecimal evaluate() {
        return super.getChild(0).evaluate().divide(super.getChild(1).evaluate());
    }

    /**
     * Return a character that represents the operation this node represents.
     * 
     * @return '/' for addition
     */
    public char getOpName() {
        return '/';
    }
}
