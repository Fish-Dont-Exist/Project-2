import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;

	/**
	 * The default constructor.
	 */
	public LinkedStack()
	{
		topNode = null;
	}

	/**
	 * Adds a new object to the linked stack.
	 * @param newEntry The object to be added to the stack.
	 */
	public void push(T newEntry)	
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}// end push

	/**
	 * Removes the top object of the linked stack.
	 * @return Returns the removed object.
	 */
	public T pop()
	{
		T top = peek(); // Might throw EmptyStackException
		//Assertion: topNode != null
		topNode = topNode.getNextNode();

		return top;
	}// end pop

	/**
	 * Returns the top object of the linked stack.
	 * @return The top object of the linked stack.
	 */
	public T peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}// end peek

	/**
	 * Checks if the linked stack is empty.
	 * @return True if the stack is empty or false otherwise.
	 */
	public boolean isEmpty()
	{
		return topNode == null;
	}// end is Empty

	/**
	 * Clears the linked stack of objects.
	 */
	public void clear()
	{
		topNode = null;
	}// end clear

	private class Node
   {
      private T    data; //Entry in the bag
      private Node next; //Link to the next node

      //Constructors

	   /**
		* The constructor that creates an initial node.
		* @param dataPortion
		*/
      private Node(T dataPortion) // This is the constructor that creates the initial node (the first desk)
      {
         this(dataPortion, null);
      }//End constructor

	   /**
		* The constructor for a non-empty chain.
		* @param dataPortion
		* @param nextNode
		*/
      private Node(T dataPortion, Node nextNode) // This is the constructor for a non-empty chain.
      {
         data = dataPortion;
         next = nextNode;
      }//End constructor

      //Methods

	   /**
		* Returns data.
		* @return The data.
		*/
      private T getData()
      {
         return data;
      }//End getData

	   /**
		* Sets data.
		* @param newData The data to be set.
		*/
      private void setData(T newData)
      {
         data = newData;
      }//End setData

	   /**
		* Returns the next node of the linked stack.
		* @return The next node of the linked stack.
		*/
	   private Node getNextNode()
      {
         return next;
      }//End getNextNode

	   /**
		* Sets the next node.
		* @param nextNode The next node to be set.
		*/
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }//End setNextNode

   }
}
