
package processortimescheduling;

public class MyJobApp {
     private static void JobArraySort(Job[] xarray) {
        int n = xarray.length;
        Job temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(xarray[j-1].getRelease() > xarray[j].getRelease()){
                    temp = xarray[j-1];
                    xarray[j-1] = xarray[j];
                    xarray[j] = temp;
                }
            }
        }
    }

 
    
    public static void main(String[] args) {
        Job.PriorityType[] pType = {Job.PriorityType.SPT, Job.PriorityType.EDF, Job.PriorityType.ERT};
        String[] pTypeString = {"SPT","EDF","ERT"};
        int totals;
        double result,avgTime;
        long startTime=0, endTime=0,executionTime = 0;
        int size[] = {1000,5000,10000,15000,20000};
        Job[] allJobs;
        for (int i = 0;i<3;i++){
            for (int j = 0;j<5;j++){
                totals = 0;
                executionTime = 0;
                for (int d = 0;d < 100;d++){
                    Job.PriorityType pt = Job.PriorityType.SPT;
                    allJobs = Job.getRndJobArray(size[j], pt);
                    JobArraySort(allJobs);
                    OnlineScheduling S = new OnlineScheduling();
                    startTime = System.nanoTime();
                    totals += S.run(allJobs);
                    endTime = System.nanoTime();
                    executionTime += endTime - startTime;
                }
                result = (double)totals/(double)100;
                avgTime = (((double)executionTime/(double)100)/1000)/1000;
                System.out.println(pTypeString[i] + "\t"  + Double.toString(result) +"\tof\t"+size[j] + "\tTime\t" + avgTime );
            }
        }      
    }
    
}
