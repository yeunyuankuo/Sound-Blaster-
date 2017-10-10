/** Yeun-Yuan(Jessie) Kuo
 * CSE 373 Summer
 * June 28, 2017
 * Homework #1 - Sound Blaster!
 */

import java.util.EmptyStackException;

/**
 * ListStack is a program that implements Stack ADT.
 * In ListStack contains methods:
 * 	- isEmpty()
 *  - push(d)
 *  - pop()
 *  - peek()
 * 
 * Exceptions:
 * Reverse throws EmptyStackException in methods pop() and peek()
 * when the stack is empty.
 * 
 * @author jessiekuo
 */
public class ListStack implements DStack {
	
	/**
	 *  ListStackNode is used to generate nodes for ListStack.
	 */
	private class ListStackNode {
		public double data;			// data stored in this node.
		public ListStackNode next;	// link to next node in the list.
		
		/**
		 * @effects Constructs a new node with data 0.0 and null link.
		 */
		public ListStackNode() {
			this(0.0, null);
		}
		
		/**
		 * @effects Constructs a new node with given data and given link.
		 * @param data   the double for this node.
		 * @param next 	 the next node of this node.
		 */
		public ListStackNode(double data, ListStackNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private ListStackNode front;	// first value in the list.
	private int count;				// count the total of nodes in the list.
	
	/** 
	 * @effects Constructs a new empty ListStackNode and count as 0.
	 */
	public ListStack() {
		front = new ListStackNode();
		count = 0;
	}
	
	/**
	 *  Checks if the ListStack is empty.
	 *  
	 *  @return true if ListStack is empty, otherwise, false.
	 */
	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add the given double into the ListStack.
	 * 
	 * @param d   the double to be added to the ListStack.
	 */
	@Override
	public void push(double d) {
		if (count == 0) {
			front.data = d;
		} else {
			ListStackNode temp = new ListStackNode(d, front);
			front = temp;
		}
		count++;
	}

	/**
	 * Returns the top node's data from the ListStack and delete that node.
	 * 
	 * @return the top double from the ListStack.
	 * @throws EmptyStackException if ListStack is empty (count == 0).
	 */
	@Override
	public double pop() {
		if (count == 0) {
			throw new EmptyStackException();
		} else {
			double value = front.data;
			front = front.next;
			count--;
			return value;
		}
	}
	
	/**
	 * Returns the top node's data from the ListStack.
	 * 
	 * @return the top double from the ListStack.
	 * @throws EmptyStackException if ListStack is empty (count == 0).
	 */
	@Override
	public double peek() {
		if (count == 0) {
			throw new EmptyStackException();
		}
		return front.data;
	}

}
