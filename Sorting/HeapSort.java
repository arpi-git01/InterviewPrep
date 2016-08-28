

public class HeapSort {

	int[] input;
	
	HeapSort(){
		
		int[] input1 = {9,12,6,13,25,4,15,7,1,3,19};
		this.input = input1;
	}
	
	
	public int[] createHeap(int[] inputArr){
		
		int size = inputArr.length;
		
		//System.out.println("{9, 12, 6, 13, 25, 4, 15, 7, 1, 3, 19}");
		//System.out.println("{0, 1,  2,  3,  4, 5,  6, 7, 8, 9, 10, }");
		//System.out.println("Size of Arr: "+size);
		
		int lastParent = (int) Math.floor(size/2);
		//System.out.println("\nReplacing begins from index: "+lastParent);
		
		//Go to floor size/2 and start going back
		for(int i=lastParent; i>=0; i--){	
			heapify(i,inputArr,size);
		}
		
		return inputArr;
	}
	
	
	public void heapify(int index, int[] inputArr, int endIndex){
		
		int i = index;
		int child1 = 2*i+1;
		int child2 = 2*i+2;
		int size = endIndex;
		
		if(child1 < size-1){
			
			System.out.println();
			System.out.println("Parent index: "+i+" ,child1 index: "+child1+" ,child2 index: "+child2);
			System.out.println("v[Parent]: "+inputArr[i]+" ,v[ch1]: "+inputArr[child1]+" ,v[ch2]: "+inputArr[child2]);
			System.out.println();

			
			

			if(inputArr[child1]> inputArr[child2] && inputArr[child1]>inputArr[i] ){
				
				System.out.println("Here...............");
				this.printArray(inputArr);
				
				int temp = inputArr[i];
				inputArr[i] = inputArr[child1];
				inputArr[child1] = temp;
				//createHeap(inputArr[child1]);
				heapify(child1, inputArr, size);
				this.printArray(inputArr);
				
				System.out.println("\n---------------------------");
				
			}
			else if(inputArr[child1]< inputArr[child2] && inputArr[child2]> inputArr[i] ){
				
				System.out.println("Here...............");
				this.printArray(inputArr);
				
				int temp = inputArr[i];
				inputArr[i] = inputArr[child2];
				inputArr[child2] = temp;
				//createHeap(inputArr[child1]);
				heapify(child2, inputArr,size);
				this.printArray(inputArr);
				
				System.out.println("\n---------------------------");	
				
				
			}
		}
		
	}
	
	public void sortHeap(int[] inputArr, int beginIndex, int endIndex){
		
		System.out.println("In sort heap =============================================>");
		//to sort the heap created through createHeap, heapify method
		
		System.out.println("Original heaped array \n");
		printArray(inputArr);
		
		System.out.println("");
		System.out.println("BeginIndex : "+beginIndex+ " ; EndIndex: "+endIndex);
		
		
		if(endIndex-beginIndex == 0){
			return;
		}
		
		else if(inputArr[0] > inputArr[endIndex]){
			int temp = inputArr[0];
			inputArr[0] = inputArr[endIndex];
			inputArr[endIndex] = temp;
			
			System.out.println("After swapping root with last elem \n");
			printArray(inputArr);
			
			heapify(beginIndex,inputArr,endIndex);
			
			printArray(inputArr);
			System.out.println("\n********************************************");
		}
		
		sortHeap(inputArr, beginIndex, endIndex-1);

	}
	
	public void printArray(int[] inputArr){
		
		System.out.println("\n\n");
		System.out.print("[");
		for(int i=0; i<inputArr.length; i++){
			
			System.out.print("  "+inputArr[i]+"  ");
			
		}
		System.out.print("]");
		System.out.println();
		System.out.print("[");
		
		for(int i=0; i<inputArr.length; i++){
			
			
			if (inputArr[i]/10 == 0){
				System.out.print("  "+i+"  ");
			}
			else{
				System.out.print("   "+i+"  ");
			}
			
		}
		
		System.out.print("]");
	}
	
	
	public static void main(String args[]){
		
		HeapSort hs = new HeapSort();
		int[] heaped = hs.createHeap(hs.input);
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		hs.sortHeap(hs.input, 0, hs.input.length-1);
		hs.printArray(hs.input);	
	}
}
