/**
 * The class Calculator implements
 * @param <T>
 */
public class Calculator<T>
{
	public String convertToPostfix(String infix)
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
//                case Character.isLetter(infix.charAt(index)) :
				postfix += infix.charAt(index);
				break;

				case '^':
					operatorStack.push(nextCharacter); // adds ^ to stack
					break;

				case '+': case '-': case '*': case '/':
				while(!operatorStack.isEmpty() && checkPrecedence(nextCharacter, operatorStack.peek())) //&& precedenc of next character <= precendence of operatorStack.peek()) // if there is something inside the operator stack
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
	 * @return true if operator one has a smaller precedence than that of operator 2 or if operator 2 is null; false otherwise
	 */
	public static boolean checkPrecedence(Character operator1, Character operator2)
	{
		switch (operator1)
		{
			case '+':
			case '-':
				// Now we are checking to make sure that operator 2 has a higher precedence
				if (operator2 == '*' || operator2 == '/') { return true;}

				else if(operator2 == '(') {break;}

			case '*':
			case '/':
				if (operator2 == '+' || operator2 == '-' || operator2 == '(')
				{
					break;
				} else if (operator2 == '*' || operator2 == '/')
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
	public static int evaluatePostfix(String postfix)
	{
		int characterCount = postfix.length();
		int index = 0;
		char nextCharacter = ' ';
//        char topOperator = ' ';

		// Initialize values of variables
		//              a  b  c  d  e
		int[] values = {2, 3, 4, 5, 6};


		ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<>();
		while (index < characterCount)
		{
			// Get next nonblank character
			nextCharacter = postfix.charAt(index);

			// Check the cases
			switch (nextCharacter)
			{
				// The cases for variables
				case 'a':
					valueStack.push(2);
					break;
				case 'b':
					valueStack.push(3);
					break;
				case 'c':
					valueStack.push(4);
					break;
				case 'd':
					valueStack.push(5);
					break;
				case 'e':
					valueStack.push(6);
					break;

				// Cases for operators
				case '+': case '-': case '*': case '/': case '^':
				int operandTwo = valueStack.pop();
				int operandOne = valueStack.pop();



			}

		}
		return 0;
	}
}
