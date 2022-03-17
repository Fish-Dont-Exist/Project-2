import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest extends Calculator<String>
{
    // TESTING CONVERT TO POSTFIX
    @Test
    public void simpleInfixExpression()
    {
        // Write infix expression
        String infix = "a+b";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        assertEquals(postfix, "ab+");
        System.out.println(postfix);
    }


    // TESTING EVALUATE POSTFIX
    @Test
    public void simplePostfixExpression()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a+b");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        System.out.println(result);
    }
}
