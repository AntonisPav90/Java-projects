
package skyline;

import java.util.ArrayList;

public class ListDoublePoints {
    public ArrayList<DoublePoint> List;
    public ArrayList<Integer> Pointers;
    
    public ListDoublePoints(){
        List = new ArrayList<DoublePoint>();
        Pointers = new ArrayList<Integer>();
    }//constructor
    
    public void printList(){
        int i;
        for (i=0;i<List.size();i++){
            if (Pointers.get(i)==1){
                System.out.println(List.get(i).toString());
            }
        }
    }//εκτύπωση λίστας σημείων skyline
    
    public int SkyLineAlg1(){
        int domTests = 0;
        int i=0;
        int j=0;
        DoublePoint p,q;
        for (i=0;i<List.size();i++){
            if (Pointers.get(i)==0){
                continue;
            }
            else {
                for (j=0;j<List.size();j++){
                    if (Pointers.get(i)==1){
                        if (List.get(i).isAbsGrater(List.get(j))){
                            domTests++;
                            Pointers.set(j, 0);
                        }
                        else if (List.get(j).isAbsGrater(List.get(i))){
                            domTests++;
                            Pointers.set(i, 0);
                        }
                        else {
                            domTests+=2;
                        }
                    }
                } 
            }
        }
        return domTests;
    }//εκτέλεση του 1ου αλγορίθμου
    
    public int SkyLineAlg2(){
        int domTests = 0;
        DoublePoint p,q;
        SortList SL = new SortList();
        SL.sort(this.List);
        if (SL.isSorted()){
            int i,j;
            for (i=0;i<this.List.size();i++){
                if (Pointers.get(i)==0){
                    continue;
                }
                else {
                    for (j=i+1;j<this.List.size();j++){
                        if (Pointers.get(j)==1){
                            domTests++;
                            if (List.get(i).isAbsGrater(List.get(j))){
                                Pointers.set(j, 0);
                            }
                        }
                    }
                }
            }
        }
        return domTests;
    }//εκτέλεση του δευτέρου αλγορίθμου
    
}
