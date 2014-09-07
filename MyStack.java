package algorithm;

import java.util.*;

public class MyStack {

  // This stack can have an additional function: to return the smallest
  // value of current stack
	
	private int MaxSize = 900;
	private Integer[] array;
	private int index;
	private Stack<Integer> minStack;
	
	public MyStack() { 
		array = new Integer[MaxSize];
		index = 0;    // index 0th is bottom, 899th is top
		minStack = new Stack<Integer>();
	}
	
	public boolean push(Integer i) {
		if (i == null)
			throw new UnsupportedOperationException();
		if (index == MaxSize)
			throw new IndexOutOfBoundsException();
		
		if (minStack.isEmpty())
			minStack.push(i);
		else {
			Integer min = minStack.peek();
			if (min > i) {
				minStack.push(i);
			}
		}
		array[index++] = i;
		return true;
	}
	
	public Integer pop() {
		if (index == 0)
			throw new IndexOutOfBoundsException();
		
		index--;
		int valueToBePop = array[index];
		if (valueToBePop == minStack.peek()) {
			minStack.pop();
		}
		return array[index];
	}
	
	public int size() {
		return index;
	}
	
	public Integer peek() {
		if (this.isEmpty())
			return null;
		
		int newIndex = index-1;
		return array[newIndex];
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	// This method can access the min value
	// in the stack.
	public Integer min() {
		return this.minStack.peek();
	}
	
	public static void main(String[] args) {
		
		MyStack m = new MyStack();
		for (int i =1; i<20; i++) {
			m.push(i);
		}
	}
}
