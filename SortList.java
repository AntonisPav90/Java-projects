
package skyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SortList {
    boolean sorted;
    
    public SortList(){
        this.sorted = false;
    }
    
    
    
    public void sort(ArrayList<DoublePoint> X){
        Collections.sort(X, new Comparator<DoublePoint>() {
        @Override
        public int compare(DoublePoint  DP1, DoublePoint  DP2)
        {
            double s1,s2;
            s1 = DP1.getDx() + DP1.getDy();
            s2 = DP2.getDx() + DP2.getDy();
            if (s1>=s2){
                return 1;
            }
            else {
                return  0;
            }
        }
        });
        this.sorted = true;
    }
    
    public boolean isSorted(){
        return this.sorted;
    }
}
