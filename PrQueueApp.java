package ergasia_domes;

import java.util.Date;

public class PrQueueApp {

    public static void main(String[] args) {
        int N = 100000;

        // <editor-fold defaultstate="collapsed" desc="PrQueueArray">
        System.out.println("*** Array implementation ***");
        PrQueueArray pqa = new PrQueueArray(N);
        Date d1 = new Date();
        for(int i=1;i<=N;i++){
            pqa.Insert(i);
        }
        Date d2 = new Date();
        long elapsedTime = d2.getTime() - d1.getTime();
        System.out.println("Insert time for " + N + " items: " + elapsedTime + " milliseconds");

        d1 = new Date();
        for(int i=0;i<N/10;i++){
            pqa.Remove();
        }
        d2 = new Date();
        elapsedTime = d2.getTime() - d1.getTime();
        System.out.println("Delete time for " + N/10 + " items: " + elapsedTime + " milliseconds");
        //pqa.Display();
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PrQueueList">
        System.out.println("\n*** Linked List implementation ***");
        PrQueueList pql = new PrQueueList();
        d1 = new Date();
        for(int i=1;i<=N;i++){
            pql.Insert(i);
        }
        d2 = new Date();
        elapsedTime = d2.getTime() - d1.getTime();
        System.out.println("Insert time for " + N + " items: " + elapsedTime + " milliseconds");

        d1 = new Date();
        for(int i=0;i<N/10;i++){
            pql.Remove();
        }
        d2 = new Date();
        elapsedTime = d2.getTime() - d1.getTime();
        System.out.println("Delete time for " + N/10 + " items: " + elapsedTime + " milliseconds");
        //pql.Display();
        // </editor-fold>
        
    }

}
