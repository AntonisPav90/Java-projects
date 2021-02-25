package btree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BinaryTreeApp {

	public static void main(String[] args) {
		int action = -1;
		while(action != 0){
			System.out.print("Give action num [1-5]: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				action = Integer.parseInt(br.readLine());
			}
			catch (IOException ioe) {
				System.out.println("IO error trying to read!");
				System.exit(1);
			}
			switch (action) {
	        	case 0:  System.exit(1);
	                 break;
	        	case 1:  action1();
                	break;
	        	case 2:  action2();
            		break;
	        	case 3:  action3();
        			break;
	        	case 4:  action4(-1);
        			break;
	        	case 5:  action5();
        			break;
			}
		}
	}

	public static void action1(){ //ylopoihsh tou prwtou erwtimatos
		BinaryTree bt = new BinaryTree();
		for(int i=1; i<=50; i++)	bt.insert(null, i);
		System.out.println("Tree Height: " + bt.getHeight(bt.getRootNode()));
	}

	public static void action2(){ //ylopoihsh tou 2 erwtimatos
		BinaryTree bt = new BinaryTree();
		bt.insert(null, 30);
		bt.insert(null, 20);
		bt.insert(null, 40);
		bt.insert(null, 10);
		bt.insert(null, 45);
		bt.insert(null, 35);
		bt.insert(null, 25);
		bt.insert(null, 9);
		bt.insert(null, 8);
		bt.insert(null, 7);
		bt.insert(null, 6);
		bt.insert(null, 5);
		bt.insert(null, 4);
		bt.insert(null, 3);
		bt.insert(null, 2);
		bt.insert(null, 1);
		System.out.println("Tree Height: " + bt.getHeight(bt.getRootNode()));
	}

	public static void action3(){ //ylopoihsh tou 3 erwtimatos
		BinaryTree bt = new BinaryTree();
		Random rg = new Random();
	    for (int i = 1; i <= 20; i++){
	    	int r = rg.nextInt(100);
	    	if(!bt.find(r, bt.getRootNode())) bt.insert(null, r);//an den yparxei o arithmos tote mono eisagetai
	    	else i--;
	    }
	    bt.printInOrder(bt.getRootNode());
	}

	public static void action4(int forceN){ //ylopoihsh tou 4 erwtimatos
		int N=-1;
		int InsertTotalCompareNum = 0;
		int FindTotalCompareNum = 0;
		if(forceN == -1){
			System.out.print("Give N: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
			}
			catch (IOException ioe) {
				System.out.println("IO error trying to read!");
				System.exit(1);
			}
		}
		else {
			N = forceN;
		}
		BinaryTree bt = new BinaryTree(); // dhmiourgeitai to keno dda
		Random rg = new Random();
		for (int i = 1; i <= N; i++){
			int r = rg.nextInt(100000);
	    	if(!bt.find(r, bt.getRootNode())) {
	    		bt.insert2(null, r);// eisagontai n tyxaioi arithmoi apo to [1,100000]
	    		InsertTotalCompareNum += bt.getMeanCompareNum();
	    		bt.resetMeanCompareNum(); //mhdenizetai o metritis
	    	}
	    	else i--;
		}
		float insertMeanCompNum = (float)InsertTotalCompareNum/(float)N;

		for (int i = 1; i <= 1000; i++){ // epilegei 1000 tyxaious arithmous
			int r = rg.nextInt(100000);
			bt.find2(r, bt.getRootNode()); // kai tous anazhta enan-enan
			FindTotalCompareNum += bt.getMeanCompareNum();
			bt.resetMeanCompareNum();
		}
		float findMeanCompNum = (float)FindTotalCompareNum/(float)1000;

		System.out.println("Insert - Mean Compare Num: " + insertMeanCompNum);
		System.out.println("Find - Mean Compare Num: " + findMeanCompNum);
		if(forceN > 0) {
			System.out.println("Tree Height: " + bt.getHeight(bt.getRootNode()));
			System.out.println("Number of Elements: " + N);
			System.out.println("------------------------------------");
		}
	}

	public static void action5(){ //ylopoihsh tou 5 erwtimatos
		action4(10000);
		action4(30000);
		action4(50000);
		action4(70000);
	}

}
