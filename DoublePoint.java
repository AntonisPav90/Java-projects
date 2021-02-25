
package skyline;

import java.util.Collections;

public class DoublePoint {
    private double dX;//διάσταση x
    private double dY;//διάσταση y
    
    public DoublePoint(){
        this.dX = 0;
        this.dY = 0;
    }//constructor
    
    public DoublePoint(double x, double y){
        this.dX=x;
        this.dY=y;
    }//constructor
    
    public double getDx(){
        return this.dX;
    }//επιστρέφει την διασταση x
    
    public double getDy(){
        return this.dY;
    }//επιστρέφει την διάσταση y
    
    public boolean isGrater(DoublePoint x){
        if ((this.dY <= x.getDy()) && (this.dX <= x.getDx())){
           return true; 
        }
        else {
            return false;
        }
    }//ελέγχει αν το σημείο υπερτερεί άλλου 
    
    public boolean isAbsGrater(DoublePoint x){
        if (this.isGrater(x)){
            if ((this.dY < x.getDy()) || (this.dX < x.getDx())){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }//ελέγχει αν το σημείο υπερτερεί απόλυτα άλλου
    
    @Override
    public String toString(){
        return " ("+this.dX+","+this.dY+") ";
    }//τυπώνει σημείο
    
    public boolean isGraterThan(DoublePoint X){
        if (this.getDx()+this.getDy() > X.getDx()+X.getDy()){
            return true;
        }
        else {
            return false;
        }
    }//σύγκριση για την κατάταξη των σημείων
}
