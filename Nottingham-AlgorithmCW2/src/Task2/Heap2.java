package Task2;


/** COMP2009-ACE 2020-21 ADE CW4   
    Author: Andrew Parkes
	
Implementation of a binary Heap represented as an array of fixed size.
*/
public class Heap2
{
	private static final int ROOT_INDEX    =  1;  // the index in the array at which the storage starts
	private static final int INIT_CAPACITY = 10;  // size used if it is not specified in creation

	//error codes - mostly not used - might be useful if you are debugging
	public static final int SUCCESS              =  0;
	public static final int ARRAY_EMPTY_ERROR    = -1;
	public static final int ARRAY_FULL_ERROR     = -2;
	
	
	private int[] heap; // the array that actually stores the heap
	private int size = 0;  // number of elements currently stored
	
	public int count = 0 ; // usual counter for the operations taken
	
	/** Default constructor setting the initial maximum capacity to 10
	 */
	public Heap2() {
		this(INIT_CAPACITY);
	}
	
	/** Sets the initial maximum capacity to the size specified by <code> size </code>
	 * @param size The initial maximum size to set the heap
	 */
	public Heap2(int size) {
		//set size to size + 1 since head is stored at index 1 rather than index 0
		this.heap = new int[size + 1];
		count += size+1;
	}

	/** @param value A non-negative integer to insert into the heap
	 * @return A status code indicating the success of the insertion of the value into the heap
	 */
	public int insert(int value) {

		if ( size >= heap.length - 1)  
		{ 
			count = count + 2; 				//count the primitive operation for comparing two numbers and subtracting two numbers
			return ARRAY_FULL_ERROR; 
		}
		count = count + 2; 				//count the primitive operation for comparing two numbers and subtracting two numbers

		// -------------- HEAP 2: INSERT AND UPHEAP -- START ----------

		heap[this.size ++] = value;						
		count = count + 3; 				//count the primitive operation for adding two number and assigning and indexing into array
		
		siftUp(this.size - 1);							
		count = count + 2;		//count the primitive operation for subtracting two numbers and calling siftUp method
		
		// -------------- HEAP 2: INSERT AND UPHEAP -- END ----------
		
		return SUCCESS;
	}
	
	private void siftUp(int index) {
		
		int e = heap[index];
		count = count + 1; 				//count the primitive operation for assigning a value into a variable
		
		while (index > 0) 
		{
			count = count + 1; 				//count the primitive operation for comparing two numbers
			
			int pindex = (index - 1) / 2;
			count = count + 3; 				//count the primitive operation for subtracting,dividing two number and assigning a value into a variable
			
			int p = heap[pindex];
			count = count + 1; 				//count the primitive operation for assigning a value into a variable

			if (e - p <= 0)
			{
				count = count + 2; 				//count the primitive operation for subtracting two numbers and comparing two numbers
				break;
			}
			count = count + 2; 				//count the primitive operation for subtracting two numbers and comparing two numbers
			
			heap[index] = heap[pindex];
			count = count + 1; 				//count the primitive operation for indexing into array
			
			index = pindex;
			count = count + 1; 				//count the primitive operation for assigning a value to a variable
		}
		
		heap[index] = e;
		count = count + 1; 				//count the primitive operation for indexing into an array
	}
	
	/** Returns the smallest value in the heap
	 * @return The value of the smallest node in the heap if successful, otherwise an error code
	 */
	public int viewMin() {
		return (size() > 0) ? heap[ROOT_INDEX] : ARRAY_EMPTY_ERROR;
	}

	/** Removes and returns the smallest value in the heap.
	 * @return The value of the smallest node in the heap if successful, otherwise an error code
	 */
	public int removeMin() {
		if ( size() <= 0 )  
		{ 
			count = count + 3; 				//count the primitive operation for calling a method, returning a method and comparing two variables
			return ARRAY_EMPTY_ERROR; 
		}
		count = count + 3; 				//count the primitive operation for calling a method, returning a method and comparing two variables
				
		//record min value, to be returned at end
		int min = viewMin();
		count = count + 3; 				//count the primitive operation for returning from a method and calling a method and assigning a value into a variable
		
		// -------------- HEAP 2: REMOVE AND DOWNHEAP -- START ----------
		
		int index = -- size;
		count = count + 3; 				//count the primitive operation for subtracting and assigning and assigning again a value into variable
		
		heap[ROOT_INDEX] = heap[index];
		count = count + 1; 				//count the primitive operation for indexing into array
		
		heap[index] = 0;
		count = count + 1; 				//count the primitive operation for indexing into array
		
		siftDown(0);
		count = count + 1; 				//count the primitive operation for calling a method

		// -------------- HEAP 2: REMOVE AND DOWNHEAP -- END ----------
		return min;
	}
	
	private void siftDown(int index) {
		int e = heap[index];
		count = count + 1; 				//count the primitive operation for assigning a value into a variable
		
		while (index > (size >> 1)) {
			count = count + 2; 				//count the primitive operation for dividing two number
			
			int cheilIndex = (index >> 1) + 1;
			count = count + 3; 				//count the primitive operation for dividing, adding and assigning a value into a variable
			
			int leftIndex = cheilIndex + 1;
			count = count + 2; 				//count the primitive operation for adding and assigning a value into a variable
			
			if (leftIndex < size && (heap[cheilIndex] - heap[leftIndex]) < 0) 
			{
				count = count + 3; 				//count the primitive operation for comparing two times and subtracting
			
				cheilIndex = leftIndex;
				count = count + 1; 				//count the primitive operation for assigning a value into variable
			}
			count = count + 3; 				//count the primitive operation for comparing two times and subtracting
			
			heap[index] = heap[cheilIndex];
			count = count + 1; 				//count the primitive operation for indexing into array
			
			index = cheilIndex;
			count = count + 1; 				//count the primitive operation for assigning a value into a variable
		}
		
		heap[index] = e;
		count = count + 1; 				//count the primitive operation for indexing into array
	}

	/** @return The number of values stored in the heap
	 */
	public int size() {
		return size;
	}

	/** @return Whether the heap is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
		
	/** @return The index of the last node
	 */
	public int getLastIndex() {
		return size();
	}
	
	/** * @param currentIndex The index of the current node
	 * @return The index of the current node's parent
	 */
	private int getParentIndex(int currentIndex) {
		return currentIndex >> 1;
	}
	
	/** @param currentIndex The index of the current node
	 * @return The index of the current node's left child
	 */
	private int getLeftChildIndex(int currentIndex) {
		return currentIndex << 1;
	}
	
	/** @param currentIndex
	 * @return The index of the current node's right child
	 */
	private int getRightChildIndex(int currentIndex) {
		return (currentIndex << 1) + 1;
	}
	
	/** @param currentIndex The index of the current node
	 * @return True if the node relating to currentIndex is a leaf node (i.e. has no children)
	 */
	private boolean isLeafNode(int currentIndex) {
		return size < getLeftChildIndex(currentIndex);
	}
}
