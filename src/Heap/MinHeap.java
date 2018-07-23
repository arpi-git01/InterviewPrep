package Heap;

import java.util.Arrays;

public class MinHeap {

	private int capacity=10;
	private int size=0;
	
	int[] items = new int[capacity];
	
	
	
	//dispalys the top most element in heap - minimum elem
	public int peek(){
		if(size == 0) throw new IllegalStateException();
		else return items[0];
		
	}
	
	
	/**
	 * @return top most - min value item or the root
	 * Replaces root with last element and heapifys doen to balance the tree
	 */
	public int poll(){
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0]= items[capacity-1];
		heapifyDown();
		return item;
		
	}
	
	
	
	
	
	
	private int getLeftChildIndex(int parentIndex){
		return 1+(2*parentIndex);
	}
	private int getRightChildIndex(int parentIndex){
		return 2+(2*parentIndex);
	}
	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	
	private boolean hasLeftChild(int parentIndex){
		return getLeftChildIndex(parentIndex) < size;
	}
	private boolean hasRightChild(int parentIndex){
		return getRightChildIndex(parentIndex) < size;
	}
	private boolean hasParent(int parentIndex){
		return getParentIndex(parentIndex) >= 0;
	}
	
	private int getLeftChild(int parentIndex){
		return items[getLeftChildIndex(parentIndex)];
	}
	private int getRightChild(int parentIndex){
		return items[getRightChildIndex(parentIndex)];
	}
	
	private int getParent(int childIndex){
		return items[getParentIndex(childIndex)];
	}
	
	
	private void swap(int indexOne, int indexTwo){
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureExtraCapacity(){
		if(size==capacity){
			items = Arrays.copyOf(items, capacity*2);
			capacity = capacity*2;
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
