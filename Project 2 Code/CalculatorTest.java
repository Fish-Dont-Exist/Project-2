import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest extends Calculator<String>
{
    // TESTING CONVERT TO POSTFIX
    @Test
    public void additionInfixExpression()
    {
        // Write infix expression
        String infix = "a+b";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        assertEquals(postfix, "ab+");
    }

    @Test
    public void subtractionInfixExpression()
    {
        // Write infix expression
        String infix = "d-c";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "dc-");
    }

    @Test
    public void multiplicationInfixExpression()
    {
        // Write infix expression
        String infix = "d*e";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "de*");
    }

    @Test
    public void divisionInfixExpression()
    {
        // Write infix expression
        String infix = "a/e";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "ae/");
    }

    @Test
    public void exponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "ab^");
    }

    @Test
    public void additionAndExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b+c";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals("ab^c+", postfix);
    }

    @Test
    public void multiplicationAndExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b*c";

        // COnvert to outfix
        String postfix = convertToPostfix(infix);

        // check equals
        assertEquals("ab^c*", postfix);
    }

    @Test
    public void divisionAndExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a/b^c";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals("abc^/", postfix);
    }

    @Test
    public void multipleExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b^c^d";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "abcd^^^");
    }

    @Test
    public void multipleOperatorsWithoutParenthesesExpression()
    {
        // Write infix expression
//        String infix = "a+b*c-d/e";
        String infix = "a+b*c-d";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
//        assertEquals(postfix, "abc*+de/-");
        assertEquals("abc*+d-",postfix);
    }

    @Test
    public void multipleOperatorsWithParenthesesExpression()
    {
        // WRite infix expression
        String infix = "a/b*(c+(d-e))";

        // Convert to outfix
        String postfix = convertToPostfix(infix);

        // Check equals
        assertEquals("ab/cde-+*", postfix);
    }



    // TESTING EVALUATE POSTFIX
    @Test
    public void SimpleSubtractionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a-b");

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        assertEquals(result, -1, 0.0001);

    }

    @Test
    public void SimpleAdditionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a+b");

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 5.0, 0.0001);
    }

    @Test
    public void SimpleMultiplicationPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("b*c");

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 12, 0.0001);
    }

    @Test
    public void SimpleDivisionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("e/b");

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 2, 0.0001);
    }

    @Test
    public void SimpleExponentPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("b^c");

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(81, result,0.0001);
    }

    @Test
    public void MixedAdditionAndMultiplicationPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a+b*c");

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 14, 0.0001);
    }

    @Test
    public void MixedAdditionAndDivisionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("b/a+c");

        // Evaluation the postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 5.5, 0.0001);
    }

    @Test
    public void MixedAdditionAndMultiplicationWithParenthesesEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("(a+b)/d");

        // Evaluate postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 1.0, 0.0001);
    }

    @Test
    public void AllOperatorsWithoutParenthesesEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("d^b-a*b/e + c");

        // Evaluate postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(128.0, result, 0.0001);
    }

    @Test
    public void AllOperatorsWithParenthesesEvaluation()
    {
        // Write postfix expression
        String postfix = convertToPostfix("a/b*(c+(d-e))");

        // Evaluate postfix expression
        double result = evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 2.0, 0.0001);
    }


}
