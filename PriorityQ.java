package processortimescheduling;

import processortimescheduling.Job.PriorityType;


public class PriorityQ{
    private Job[] Queue;
    private int length;
    private int size;
    
    public PriorityQ(){
        this.length = 0;
    }
    
    public PriorityQ(int s){
        this.size = s;
        this.Queue = new Job[s];
        this.length = 0;
    }
    
    public boolean isEmpty(){
        return (this.length==0);
    }
    
    public void add(Job J){
        if (this.isEmpty()){
            this.Queue[0] = J;
            this.length = 1;
        }
        else {
            
            this.Queue[this.length] = J; 
            this.length++;
            int i = this.length-1; 
            int p = i / 2; 
            while ((i > 0) && ((this.Queue[p].lessImportantThan(this.Queue[i])  ))) { 
                swap(this.Queue[p], this.Queue[i]);
                i = p; 
                p = i / 2; 
            } 
        }
    }

    public Job get(){
        if (this.isEmpty()==false){
            Job ret = this.Queue[0];
            this.Queue[0] = this.Queue[this.length-1];
            this.length--;
            reconstruct(0);
            return ret;
        }
        else {
            return null;
        }
    }
    
    public void reconstruct(int i){   
        if (this.length>1){
            int l = 2*i; 
            int r = 2*i+1; 
            int temp = i;

            if ((l < this.length) && (this.Queue[l].moreImportantThan(this.Queue[temp]))){
               temp = l;
            }
            else if ((r < this.length) && (this.Queue[r].moreImportantThan(this.Queue[temp]))){
                temp = r;
            }
            if (temp != i) {
                swap(this.Queue[i], this.Queue[temp]);
                reconstruct(temp);
            }

            
        }
    }
    
    public void swap(Job j1,Job j2){
        Job temp;
        temp = j1;
        j1 = j2;
        j2 = temp;
    }

    
  
}
