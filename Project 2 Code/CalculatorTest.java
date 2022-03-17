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
    public void SimpleSubtractionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a-b");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        assertEquals(result, -1);
        System.out.println(result);
    }

    @Test
    public void SimpleAdditionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a+b");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 5);
    }

    @Test
    public void SimpleMultiplicationPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("b*c");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 12);
    }

    @Test
    public void SimpleDivisionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("e/b");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 2);
    }

    @Test
    public void SimpleExponentPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("b^c");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 81);
    }

    @Test
    public void MixedAdditionAndMultiplicationPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a+b*c");

        // Evaluate the postfix expression
        int result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 14);
    }

    @Test
    public void MixedAdditionAndDivisionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("b/a+c");

        // Evaluation the postfix expression
        float result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 5.5, 0.00001);
    }

}
