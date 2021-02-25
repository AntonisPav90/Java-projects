
package processortimescheduling;

import java.util.ArrayList;

public class OnlineScheduling {
    private ArrayList<Job> JobQueue;
    
    public OnlineScheduling(){
        JobQueue = new ArrayList<>();
    } 
    
    public Job getJobReleazed(int t,Job[] ja){
        Job ret = null;
        int i;
        for (i=0;i<ja.length;i++){
            if (ja[i].getRelease()==t){
                ret = ja[i];
                break;
            }
            else if (ja[i].getRelease()>t){
                break;
            } 
        }
        return ret;
    }
    
    public int run(Job[] J){
        PriorityQ PQ = new PriorityQ(J.length);
        int timer = -1;
        int timeLeft = 0;
        int jobCounter = 0;
        Job checkedJob;
        Job currentJob;
        int jobsProcessed = 0;
        int jobsNotProcessed = 0;
        while (true){
            timer++;
            if (jobCounter==J.length){
                if (PQ.isEmpty()){
                    if (timeLeft == 0){
                        break;
                    }
                }
            }
            if (this.getJobReleazed(timer, J)!=null){//έφθασε νέα εργασία
                PQ.add(J[jobCounter]);
                jobCounter++;
            }
            if (timeLeft == 0){
                if (PQ.isEmpty() == false){
                    checkedJob = PQ.get();
                    if (checkedJob.getDeadline()-timer+1 >= checkedJob.getProcTime()){
                        currentJob = checkedJob;
                        timeLeft = currentJob.getProcTime();
                        checkedJob = null;
                        jobsProcessed++;
                    }
                    else {
                        timeLeft = 0;
                        checkedJob = null;
                        currentJob = null;
                        jobsNotProcessed++;
                    }            
                }
                else {
                    timeLeft--;
                }
            }
            else {
                timeLeft--;
            }
            
        }
        return jobsProcessed;
    }
}
