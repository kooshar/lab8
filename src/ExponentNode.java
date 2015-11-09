import java.math.BigDecimal;

public class ExponentNode extends Node {

    /**
     * Create a new node that represents an exponential operation. The two children
     * of this node represent the two operands, although they may be
     * subexpressions that need to be evaluated.
     * 
     * @param leftNode
     * @param rightNode
     * @throws MalformedExpressionException if the right node is an integer
     * @requires rightNodes evaluation should be an integer
     */
    public ExponentNode(Node leftNode, Node rightNode) throws MalformedExpressionException {
        super(leftNode, rightNode);
        final double ACCURACY=0.000001;
        
        if(Math.abs(rightNode.evaluate().doubleValue()-rightNode.evaluate().intValue())>ACCURACY){
            throw new MalformedExpressionException("division byzero not supported");
        }
    }

    /**
     * Evaluate the exponential operation by evaluating the two child nodes and
     * then raising one to the power of the other.
     * 
     * @return the left node to the power of right node 
     */
    public BigDecimal evaluate() {
        return super.getChild(0).evaluate().pow(super.getChild(1).evaluate().intValue());
    }

    /**
     * Return a character that represents the operation this node represents.
     * 
     * @return '^' for addition
     */
    public char getOpName() {
        return '^';
    }
}
