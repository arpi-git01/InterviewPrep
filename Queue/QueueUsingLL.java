/* http://cs.lmu.edu/~ray/notes/queues/
 * 
 * A queue is a linear DS where elements are inserted at rear(last) position and 
 * elements are deleted from front(start) position
 * Follows principle of FCFS/FIFO
 * Just like a queue in a supermarket.
 * Add element - rear++, delete element - front++
 * 
 * Applications:
 * 1. Scheduling of tasks - job and CPU scheduling
 * 2. calls at call center
 * 
 * Elem |	| 	| 	|   |   |	|
 * Front| n |   |   |   |   |	|	
 * Rear | n |   |   |   |   |	|	note n is null
 * 
 * Elem |	| 8	| 7	| 2 | 6 |	|
 * Front|   | f |   |   |   |	|	
 * Rear |   |   |   |   | r |	|	
 * 
 * Elem |	|  	| 7	| 2 | 6 |	|
 * Front|   |   | f |   |   |	|	
 * Rear |   |   |   |   | r |	|	

 * Elem |	|  	| 	|   | 6 |	|
 * Front|   |   |   |   | f |	|	
 * Rear |   |   |   |   | r |	|	

 * The basic operations are:
 * 1. enqueue(x): add an item at the tail
 * 2. dequeue: remove the item at the head
 * 3. peek: return the item at the head (without removing it)
 * 4. size: return the number of items in the queue
 * 5. isEmpty: return whether the queue has no items
 * 
 * Implementation:
 * 1. Array
 * 2. Linked List
*/


class QueueNode{
	int data;
	QueueNode next;
	
	QueueNode(){} //default constructor
	QueueNode(int val) { data = val; next = null; } 
}


public class QueueUsingLL {

	QueueNode front;
	QueueNode rear;
	int size;
	
	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}

	/**
	 * enqueue(x): add an item at the tail/rear
	 * 
	 */
	public void enqueue(int val){
		QueueNode newNode = new QueueNode(val);
		System.out.println("Enqued : "+val+" size: "+size+1);
		if(front == null){ //no node in queue - both front and rear points to first node
			front = rear = newNode;
		} 
		else{ //only rear increments
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
}
