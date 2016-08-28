//Check if given BT is balanced
// A BTree is balanced when height of each 2 subtress differ at most by 1


public class CheckBalanced {

	public CheckBalanced() {
		// TODO Auto-generated constructor stub
	}

	public int checkHeight(BTNode root){
		
		if(root == null){
			return -1;
		}
		
		int htLeftTree = 1 + checkHeight(root.left) ;
		int htRightTree = 1 + checkHeight(root.right);
		int htDiff = Math.abs(htLeftTree-htRightTree);
		
		if(htDiff > 1){
			return Integer.MIN_VALUE;
		}
		return Math.max(htLeftTree,htRightTree);
	}
	
	public boolean checkBalanced(BTNode root){
		int ht = this.checkHeight(root);
		if(ht == Integer.MIN_VALUE)
			return false;
		else
			return true;
	}
	
	public static void main(String args[]){
		BT bt = new BT();
		bt.createSampleTree();
		BTNode root = bt.root; //contains root of sample Binary Tree
		CheckBalanced chk = new CheckBalanced();
		System.out.println(chk.checkBalanced(root));
		
	}
}
