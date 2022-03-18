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
