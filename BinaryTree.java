package btree;

public class BinaryTree {
	private BinaryNode root;
	private int meanCompareNum = 0;

	public BinaryTree(){ //constructor
		this.root = new BinaryNode(-1); // epeidi i binarynode den mporei na parei tin timi null(default parametros) tin kaloume me -1
	}

	public BinaryNode getRootNode(){
		return this.root;
	}

	public boolean isEmpty() {
		return this.root.getNodeValue() == -1;
	}

	public void insert(BinaryNode node, int value) {
		if(this.isEmpty()) {
			this.root.setNodeValue(value);
			return;
		}
		if (node == null) node = this.root;

		if (value < node.getNodeValue()) {
			if (node.getLeftNode() != null) {
				insert(node.getLeftNode(), value);
			}
			else {
				node.setLeftNode(new BinaryNode(value));
			}
	    }
		else if (value > node.getNodeValue()) {
			if (node.getRightNode() != null) {
				insert(node.getRightNode(), value);
			}
			else {
				node.setRightNode(new BinaryNode(value));
			}
	    }
	}

	public void insert2(BinaryNode node, int value) { //gia ta erwthmata 4 k 5
		if(this.isEmpty()) {
			meanCompareNum++;
			this.root.setNodeValue(value);
			return;
		}
		if (node == null) node = this.root;

		if (value < node.getNodeValue()) {
			if (node.getLeftNode() != null) {
				insert2(node.getLeftNode(), value);
			}
			else {
				node.setLeftNode(new BinaryNode(value));
			}
			meanCompareNum++;
	    }
		else if (value > node.getNodeValue()) {
			if (node.getRightNode() != null) {
				insert2(node.getRightNode(), value);
			}
			else {
				node.setRightNode(new BinaryNode(value));
			}
			meanCompareNum++;
	    }
	}

	public boolean find(int value, BinaryNode bn) { //gia to erwtima 2
        while( bn != null ) {
            if( value < bn.getNodeValue() )
                bn = bn.getLeftNode();
            else if( value > bn.getNodeValue() )
            	bn = bn.getRightNode();
            else
                return true;
        }
        return false;
    }

	public boolean find2(int value, BinaryNode bn) { //gia ta erwtimata 4 k 5
        while( bn != null ) {
        	meanCompareNum++;
        	if( value < bn.getNodeValue() )
                bn = bn.getLeftNode();
            else if( value > bn.getNodeValue() )
            	bn = bn.getRightNode();
            else
                return true;
        }
        return false;
    }

	public int getMeanCompareNum(){
		return this.meanCompareNum;
	}

	public void resetMeanCompareNum(){
		this.meanCompareNum = 0;
	}

	public int getHeight(BinaryNode node){
		if(node == null)
			return -1;
		else
			return 1 + Math.max(this.getHeight(node.getLeftNode()), this.getHeight(node.getRightNode()));
	}

	public void printInOrder(BinaryNode node) {
		if (node != null) {
			printInOrder(node.getLeftNode());
			System.out.println("Traversed: " + node.getNodeValue());
			printInOrder(node.getRightNode());
	    }
	}
}
