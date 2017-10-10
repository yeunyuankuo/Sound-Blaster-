/** Yeun-Yuan(Jessie) Kuo
 * CSE 373 Summer
 * June 28, 2017
 * Homework #1 - Sound Blaster!
 */

import java.util.EmptyStackException;

/**
 * ArrayStack is a program that implements Stack ADT.
 * In ArrayStack contains methods:
 * 	- isEmpty()
 *  - push(d)
 *  - pop()
 *  - peek()
 *  - increaseSize()
 *  - reduceSize()
 * 
 * Exceptions:
 * Reverse throws EmptyStackException in methods pop() and peek()
 * when the stack is empty.
 * 
 * @author jessiekuo
 */
public class ArrayStack implements DStack {
	
	double[] stackArray;	// declare a stackArray
	int size = 4;			// set size of stackArray to be 4
	int index = 0;			// set index to track the top element on the stackArray
	
	/** 
	 * @effects Constructs a new empty stackArray
	 */
	public ArrayStack() {
		stackArray = new double [size];
	}
	
	/**
	 *  Checks if the stackArray is empty.
	 *  
	 *  @return true if stackArray is empty, otherwise, false.
	 */
	@Override
	public boolean isEmpty() {
		if (index == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Adds the given double into the stackArray. 
	 * Doubles the size of the stackArray if full (index == size).
	 * Reduce the size of the stackArray to half if 3/4 of the stackArray 
	 * if empty.
	 * 
	 * @param d   the double to be added to the stackArray.
	 */
	@Override
	public void push(double d) {
		if (index == size) {
			increaseSize();
		} else if (((double)size / (double)index) == 4.0) {
			reduceSize();
		}
		stackArray[index] = d;
		index++;
	}

	/**
	 * Returns the top double on the stackArray.
	 * Reduce the size of the stackArray to half if 3/4 of the stackArray 
	 * if empty.
	 * 
	 * @return the top double on the stackArray.
	 * @throws EmptyStackException if stackArray is empty (index == 0).
	 */
	@Override
	public double pop() {
		if (index == 0) {
			throw new EmptyStackException();
		} else if ((double)size / (double)index == 4.0) {
			reduceSize();
		}
		double current = stackArray[index-1];
		index--;
		return current;
	}

	/**
	 * Returns the top double on the stackArray.
	 * 
	 * @return the top double on the stackArray.
	 * @throws EmptyStackException if stackArray is empty (index == 0).
	 */
	@Override
	public double peek() {
		if (index == 0) {
			throw new EmptyStackException();
		}
		return stackArray[index-1];
	}
	
	/**
	 * Doubles the size of the stackArray.
	 */
	private void increaseSize() {
		double[] temp = new double [size*2];
		for (int i = 0; i < index; i++) {
			temp[i] = stackArray[i];
		}
		size = size * 2;
		stackArray = temp;
	}
	
	/**
	 * Reduces the size of the stackArray to half.
	 */
	private void reduceSize() {
		double[] temp = new double [size/2];
		for (int i = 0; i < index; i++) {
			temp[i] = stackArray[i];
		}
		size = size / 2;
		stackArray = temp;
	}
}
