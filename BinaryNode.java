package btree;

public class BinaryNode {
	private int value;
	private BinaryNode leftNode;
	private BinaryNode rightNode;

	public BinaryNode(int value){ // constructor
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}

	public int getNodeValue(){
		return this.value;
	}

	public void setNodeValue(int value){
		this.value = value;
	}

	public BinaryNode getLeftNode(){
		return this.leftNode;
	}

	public void setLeftNode(BinaryNode node){
		this.leftNode = node;
	}

	public BinaryNode getRightNode(){
		return this.rightNode;
	}

	public void setRightNode(BinaryNode node){
		this.rightNode = node;
	}
}
