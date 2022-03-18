import java.util.Arrays;
import java.util.EmptyStackException;

public final class ResizeableArrayStack<T> implements StackInterface<T> 
{
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	/**
	 * The default constructor.
	 */
	public ResizeableArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}// end default constructor

	/**
	 * A constructor that initializes a ResizableArrayStack with a specified initial capacity.
	 * @param initialCapacity Specifies the initial capacity the resizable array stack should have.
	 */
	public ResizeableArrayStack(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);

		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	}

	/**
	 * Adds an object to the stack.
	 * @param newEntry The object to be added to the stack.
	 */
	public void push(T newEntry)
	{
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}// end push

	/**
	 * Removes the top object from the stack.
	 * @return Returns the object removed from the stack, or null if it did not work.
	 */
	public T pop()
	{
		checkIntegrity();
		if(isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}// end if
	}// end pop

	/**
	 * Returns the object on the top of the stack.
	 * @return Returns the object on the top of the stack.
	 */
	public T peek()
	{
		checkIntegrity();
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}// end peek

	/**
	 * Checks if the stack is empty.
	 * @return Returns true if the stack is empty and false otherwise.
	 */
	public boolean isEmpty()
	{
		return topIndex < 0;
	}// end isEmpty

	/**
	 * Clears the stack of objects.
	 */
	public void clear()
	{
		checkIntegrity();

		// remove references to the objects in the stack,
		//but do not deallocate the array
		while (topIndex > -1)
		{
			stack[topIndex] = null;
			topIndex--;
		}// end while
		//Assertion: topIndex is -1
	}// end clear


	/**
	 * Ensures the capacity of the stack does not exceed the max length.
	 */
	public void ensureCapacity()
	{
		if (topIndex >= stack.length - 1)// if array is full, double its size
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}

	/**
	 * Ensures the integrity of the stack.
	 */
	private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("ResizableArrayBag object is corrupt.");
        } // end checkIntegrity
    }

	/**
	 * Checks if the capacity of the stack exceeds the max capacity.
	 * @param capacity The capacity to be checked.
	 */
	private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY) throw new IllegalStateException("Attempt to create a bag whose" +
                " capacity exceeds allowed " + "maximum of " + MAX_CAPACITY);
    } // end checkCapacity
}
