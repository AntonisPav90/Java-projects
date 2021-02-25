package ergasia_domes;

public class PrQueueArray {

    private int[] qArray;
    private int nItems;

    //constractor
    public PrQueueArray(int N) {
        qArray = new int[N];
        nItems = 0;
    }

    //eisagwgi stoixeiwn
    //elegxos sthn periptwsi pou i oura einai gemati
    public void Insert(int item){
        if (this.isFull()) {
            System.out.println("Error: Queue is full, cannot insert item " + item);
            return;
        }

        int i;
        if (nItems == 0) {
            qArray[nItems++] = item;
        }
        else
        {
          for (i = nItems - 1; i >= 0; i--)
          {
            if (item > qArray[i])
              qArray[i + 1] = qArray[i];
            else
              break;
          }
          qArray[i + 1] = item;
          nItems++;
        }
    }

    //afairesh stoixeiwn
    //elegxos sthn periptwsh pou i oura einai adeia
    public void Remove() {
        if(nItems == 0) {
            System.out.println("Error: Queue is empty, cannot remove");
            return;
        }

        for (int i = 0; i <nItems-1; i++)
            qArray[i] = qArray[i+1];
        nItems--;
        qArray[nItems] = 0;
    }

    //methodos pou elegxei an i oura einai adeia
    public boolean isEmpty(){
        return nItems==0 ? true : false;
    }

    //methodos pou elegxei an i oura einai gemati
    private boolean isFull(){
        return nItems==qArray.length ? true : false;
    }

    //emfanisi twn stoixeiwn tis ouras sthn othoni
    public void Display(){
        for(int i=0; i<qArray.length; i++)
            System.out.println(qArray[i]);
    }
}
