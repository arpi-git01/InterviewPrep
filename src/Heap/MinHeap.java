package Heap;


/*
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&t=4s
 */

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
		items[0]= items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	/**
	 * @return the item that is added
	 * @param item
	 * Adds an item to the heap, by adding it at last position and heapifying up to place in proper position
	 */
	public void add(int item){
		ensureExtraCapaity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	/*
	 * places the element to the correct location by looking heap up from bottom
	 * item to be heapified is compared with the parent and swapped is parent is bigger than the item and so on until there is no parent 
	 */
	public void heapifyUp(){
		int index = size-1;
		while(hasParent(index) && items[index] < items[getParent(index)]){
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	/*
	 * places the element to the correct location by looking heap bottom from root
	 * item to be heapified is compared with the childs and swapped
	 */
	public void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			
			int smallerChildIndex = getLeftChildIndex(index);
			if( hasRightChild(index) && getRightChildIndex(index) < getLeftChild(index)){
				//if right child is smaller than left child
				smallerChildIndex = getRightChildIndex(index);
			}
			
			
			if(items[index] < items[smallerChildIndex])
				break;
			else
				swap(index, smallerChildIndex);
			
			index=smallerChildIndex;
			
		}
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
	
	private void ensureExtraCapaity(){
		if(size==capacity){
			items = Arrays.copyOf(items, capacity*2);
			capacity = capacity*2;
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
