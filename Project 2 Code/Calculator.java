/**
 * The class Calculator implements the methods convertToPostFix, checkPrecedence,
 * evaluatePostFix, and calculateResult.
 * @param <T> An unspecified object that can be replaced with any object.
 */
public class Calculator<T>
{
	/**
	 * The main method.
	 * @param args The String arguments being passed into the main method.
	 */
	public static void main(String[] args)
	{
		// Create the infix expression
		String infix = "a*b/(c-a) + d*e";

		// Convert the infix expression to a postfix expression
		String postfix = convertToPostfix(infix);

		// Print out the result
		System.out.print("The converted infix expression is: " + postfix + "\n");

		// Evaluate postfix expression
		double result = evaluatePostfix(postfix);

		// Print results
		System.out.println("The result of the evaluation (where a = 2, b = 3, c = 4, d = 5, e = 6) is " + result);
	}

	/**
	 * Will convert infix string expression to postfix string expression
	 * @param infix String expression that will be converted to postfix
	 * @return string that is postfix version of input infix expression
	 */
	public static String convertToPostfix(String infix)
	{
		int characterCount = infix.length();
		int index = 0;
		char nextCharacter = ' ';
		char topOperator = ' ';

		LinkedStack<Character> operatorStack = new LinkedStack<>();
		String postfix = "";

		while (index < characterCount) // while there are characters left in the string
		{
			nextCharacter = infix.charAt(index); // get character at index
			switch(nextCharacter) // check what type the character is
			{
				case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': //if it is a variable add it to postfix
				postfix += infix.charAt(index);
				break;

				case '^':
					operatorStack.push(nextCharacter); // adds ^ to stack
					break;

				case '+': case '-': case '*': case '/':
				while(!operatorStack.isEmpty() && checkPrecedence(nextCharacter, operatorStack.peek())) //&& precedence of next character <= precendence of operatorStack.peek()) // if there is something inside the operator stack
				{
					postfix += operatorStack.peek(); // add the top item of the stack
					operatorStack.pop(); // remove top item of the stack
				}
				operatorStack.push(nextCharacter); // add character to stack
				break;

				case '(':
					operatorStack.push(nextCharacter); // add character to stack
					break;
				case ')':
					topOperator = operatorStack.peek(); // sets topOperator to top stack item
					operatorStack.pop(); // removes top of the stack
					while (topOperator != '(')
					{
						postfix += topOperator; // add topOperator to postfix
						topOperator = operatorStack.peek(); // add top of stack to topOperator
						operatorStack.pop(); // remove top of stack
					}
					break;

				default: break;
			}
			index++;
		}
		while (!operatorStack.isEmpty())
		{
			topOperator = operatorStack.peek();
			operatorStack.pop();
			postfix += topOperator;
		}

		return postfix;
	} // end convertToPostFix


	/**
	 * Will compare the precedence of two operators
	 * @param operator1 Operator 1
	 * @param operator2 Operator 2
	 * @return true if operator one has a smaller or equal to precedence than that of operator 2 or if operator 2 is null; false otherwise
	 */
	private static boolean checkPrecedence(Character operator1, Character operator2)
	{
		switch (operator1)
		{
			case '+':
			case '-':
				// Now we are checking to make sure that operator 2 has a higher precedence
				if (operator2 == '*' || operator2 == '/' || operator2 == '^' || operator2 == '-' || operator2 == '+') { return true;}

				else if(operator2 == '(') {break;}

			case '*':
			case '/':
				if (operator2 == '+' || operator2 == '-' || operator2 == '(')
				{
					break;
				}
				else if (operator2 == '*' || operator2 == '/' || operator2 == '^')
				{
					return true;
				}
		}
		return false;
	}


	/**
	 * This algorithm will take in a postfix expression and will evaluate it.
	 * @param postfix The postfix expression that will be evaluated
	 * @return The result of the postfix evaluation.
	 */
	public static double evaluatePostfix(String postfix)
	{
		int characterCount = postfix.length();
		int index = 0;
		char nextCharacter = ' ';
//        char topOperator = ' ';

		// Initialize values of variables
		//              a  b  c  d  e
		int[] values = {2, 3, 4, 5, 6};


		ResizeableArrayStack<Double> valueStack = new ResizeableArrayStack<>();
		while (index < characterCount)
		{
			// Get next non-blank character
			nextCharacter = postfix.charAt(index);

			// Check the cases
			switch (nextCharacter)
			{
				// The cases for variables
				case 'a':
					valueStack.push(2.0);
					break;
				case 'b':
					valueStack.push(3.0);
					break;
				case 'c':
					valueStack.push(4.0);
					break;
				case 'd':
					valueStack.push(5.0);
					break;
				case 'e':
					valueStack.push(6.0);
					break;

				// Cases for operators
				case '+': case '-': case '*': case '/': case '^':
					double operandTwo = valueStack.pop();
					double operandOne = valueStack.pop();

					// Calculate the result of the operation and its two operands
					double result = calculateResult(nextCharacter,operandOne, operandTwo);

					// Push the result onto the valueStack
					valueStack.push(result);
					break;
				default: break; // Ignore unexpected characters
			} // end switch
			index ++;
		} // end while
		return valueStack.peek();
	} // end evaluatePostfix


	/**
	 * Calculates the result of the two operands and the operation
	 * @param operation  The operation that is passed into the function; (+, -, *, /, ^)
	 * @param operandOne The first operand of the expression  (comes before operator)
	 * @param operandTwo The second operand of the expression (comes after operator)
	 * @return result of the two operands and the operation (double)
	 */
	private static double calculateResult(Character operation, double operandOne, double operandTwo)
	{
		double result = 0;
		switch (operation)
		{
			case '+':
				return operandOne + operandTwo;
			case '-':
				return operandOne - operandTwo;
			case '*':
				return operandOne * operandTwo;
			case '/':
				return (float) operandOne/operandTwo;
			case '^':
				int operand1 = (int) operandOne;
				int operand2 = (int) operandTwo;
				return Math.pow(operand1, operand2);
		}
		return result;
	}
}
