
public class RemoveNode {

	
	public LLNode removeNode(LLNode start, int value){
		
		if(start == null) //if LL is empty
			return start;
		
		if(start.data == value){ //if value is present in the first node in LL
			start = start.next;
			return start;
		}
		
		LLNode prev = null;
		LLNode temp = start;
		
		while(temp != null && temp.data != value){ //loop over LL to find the node so to set its prev to its next to remove the node
									//also handles the case if the node to be found is the last node
				prev = temp;
				temp = temp.next;
		}
		
		if(temp == null){ //if value is not present in LL
			System.err.println("Value : "+value+" is not found in LL");
			return start;
		}
		prev.next = temp.next; //when value is found delete node
		return start;
	}
	
	public static void main(String args[]){
		LL ll = new LL();
		ll.createSampleLL();
		RemoveNode rn = new RemoveNode();
		ll.start = rn.removeNode(ll.start, 0); //first node
		ll.displayLL();
		ll.start = rn.removeNode(ll.start, 6); //last node
		ll.displayLL();
		ll.start = rn.removeNode(ll.start, 4); //Intermediate node
		ll.displayLL();
		ll.start = rn.removeNode(ll.start, 10); //node not present
		ll.displayLL();
		
	}

}
