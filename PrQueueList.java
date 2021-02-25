package ergasia_domes;

import java.util.LinkedList;

public class PrQueueList {
    private LinkedList list;

    public PrQueueList() {
        list = new LinkedList();
    }

    //eisagwgi stoixeiwn
    //elegxos stin periptwsi pou i oura einai adeia
    public void Insert(int item){
        int i,t;

        if (this.isEmpty()) {
            list.add(item);
            return;
        }

        for (i = 0; i < list.size(); i++)
        {
            t = Integer.parseInt(list.get(i).toString());
            if (item > t){
                list.add(i, item);
                break;
            }
        }
    }

    //afairesi stoixeiwn
    //elegxos stin periptwsi pou i oura einai adeia
    public void Remove() {
        if(this.isEmpty()) {
            System.out.println("Error: Queue is empty, cannot remove");
            return;
        }

        list.remove();
    }

    //methodos pou elegxei an i oura einai adeia
    public boolean isEmpty(){
        return list.size() == 0 ? true : false;
    }

    //methodos pou emfanizei ta stoixeia tis ouras stin othoni
    public void Display(){
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i).toString());
    }
}
