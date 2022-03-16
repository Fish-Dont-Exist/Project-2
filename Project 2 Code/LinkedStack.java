import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;

	public LinkedStack()
	{
		topNode = null;
	}

	public void push(T newEntry)	
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}// end push

	public T pop()
	{
		T top = peek(); // Might throw EmptyStackException
		//Assertion: topNode != null
		topNode = topNode.getNextNode();

		return top;
	}// end pop

	public T peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}// end peek

	public boolean isEmpty()
	{
		return topNode == null;
	}// end is Empty

	public void clear()
	{
		topNode = null;
	}// end clear


	public String convertToPostFix(String infix)
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
				case 'a': case 'b': case 'c': case 'd': //if it is a variable add it to postfix
					postfix += infix.charAt(index);
					break;

				case '^':
					operatorStack.push(nextCharacter); // adds ^ to stack
					break;

				case '+': case '-': case '*': case '/':
					while(!operatorStack.isEmpty()) // if there is something inside the operator stack
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
	}

	private class Node
   {
      private T    data; //Entry in the bag
      private Node next; //Link to the next node

      //Constructors
      private Node(T dataPortion) // This is the constructor that creates the initial node (the first desk)
      {
         this(dataPortion, null);
      }//End constructor

      private Node(T dataPortion, Node nextNode) // This is the constructor for a non-empty chain.
      {
         data = dataPortion;
         next = nextNode;
      }//End constructor

      //Methods
      private T getData()
      {
         return data;
      }//End getData

      private void setData(T newData)
      {
         data = newData;
      }//End setData

      private Node getNextNode()
      {
         return next;
      }//End getNextNode

      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }//End setNextNode

   }
}
