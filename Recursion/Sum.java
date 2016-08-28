
public class Sum {

	public int getSum(int no){
	
		if(no == 1)
			return no;
		else{
			int sumPrev = getSum(no-1);
			System.out.println("Sum of 0 to "+no+" is: "+ (no + sumPrev));
			return no + sumPrev ;
		}
		
	}
	
	public static void main(String args[]){
		Sum sum = new Sum();
		sum.getSum(5);
		
	}
}
