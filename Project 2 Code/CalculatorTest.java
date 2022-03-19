import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest //extends Calculator<String>
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

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "dc-");
    }

    @Test
    public void multiplicationInfixExpression()
    {
        // Write infix expression
        String infix = "d*e";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "de*");
    }

    @Test
    public void divisionInfixExpression()
    {
        // Write infix expression
        String infix = "a/e";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "ae/");
    }

    @Test
    public void exponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "ab^");
    }

    @Test
    public void additionAndExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b+c";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals("ab^c+", postfix);
    }

    @Test
    public void multiplicationAndExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b*c";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // check equals
        assertEquals("ab^c*", postfix);
    }

    @Test
    public void divisionAndExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a/b^c";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals("abc^/", postfix);
    }

    @Test
    public void multipleExponentInfixExpression()
    {
        // Write infix expression
        String infix = "a^b^c^d";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals(postfix, "abcd^^^");
    }

    @Test
    public void multipleOperatorsWithoutParenthesesExpression()
    {
        // Write infix expression
//        String infix = "a+b*c-d/e";
        String infix = "a+b*c-d";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
//        assertEquals(postfix, "abc*+de/-");
        assertEquals("abc*+d-",postfix);
    }

    @Test
    public void multipleOperatorsWithParenthesesExpression()
    {
        // WRite infix expression
        String infix = "a/b*(c+(d-e))";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Convert to outfix
        String postfix = calc.convertToPostfix(infix);

        // Check equals
        assertEquals("ab/cde-+*", postfix);
    }



    // TESTING EVALUATE POSTFIX
    @Test
    public void SimpleSubtractionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "ab-";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        assertEquals(result, -1, 0.0001);

    }

    @Test
    public void SimpleAdditionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "ab+";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 5.0, 0.0001);
    }

    @Test
    public void SimpleMultiplicationPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "bc*";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 12, 0.0001);
    }

    @Test
    public void SimpleDivisionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "eb/";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 2, 0.0001);
    }

    @Test
    public void SimpleExponentPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "bc^";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(81, result,0.0001);
    }

    @Test
    public void MixedAdditionAndMultiplicationPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "abc*+";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 14, 0.0001);
    }

    @Test
    public void MixedAdditionAndDivisionPostfixEvaluation()
    {
        // Write postfix expression
        String postfix = "ba/c+";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 5.5, 0.0001);
    }

    @Test
    public void MixedAdditionAndMultiplicationWithParenthesesEvaluation()
    {
        // Write postfix expression
//        String postfix = convertToPostfix("(a+b)/d");
        String postfix = "ab+d/";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 1.0, 0.0001);
    }

    @Test
    public void AllOperatorsWithoutParenthesesEvaluation()
    {
        // Write postfix expression
//        String postfix = convertToPostfix("d^b-a*b/e + c");
        String postfix = "db^ab*e/-c+";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(128.0, result, 0.0001);
    }

    @Test
    public void AllOperatorsWithParenthesesEvaluation()
    {
        // Write postfix expression
//        String postfix = convertToPostfix("a/b*(c+(d-e))");
        String postfix = "ab/cde-+*";

        // Create calculator object
        Calculator<String> calc = new Calculator<>();

        // Evaluate the postfix expression
        double result = calc.evaluatePostfix(postfix);

        // Test equals
        assertEquals(result, 2.0, 0.0001);
    }
}
