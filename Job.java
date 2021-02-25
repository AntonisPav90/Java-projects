package processortimescheduling;

import java.util.Random;

class Job {
	public enum PriorityType {SPT, EDF, ERT};

	public int getDeadline() { return(deadline); }
	public int getRelease() { return(release); }
	public int getProcTime() { return(procTime); }

	public static Job[] getRndJobArray(int n, Job.PriorityType type) {

		int[] M = new int[3];
		M[0] = (int)Math.ceil(Math.log10((double)n));
		M[1] = (int)Math.ceil(Math.sqrt((double)n));
		M[2] = (int)Math.ceil((double)n/2);

		Job[] jobArray = new Job[n];
		Random rndGen = new Random(System.currentTimeMillis());

		for(int i = 0; i < n; i++) {

			double density = rndGen.nextDouble();
			int procTime;

			int margin = M[rndGen.nextInt(M.length)];

			if (margin*density >= 1.0) 
				procTime = (int)(Math.ceil(margin*density));
			else procTime = 1;

			jobArray[i] = new Job(i, i+margin, procTime, type);
		}

		return(jobArray);
	}

	public boolean moreImportantThan(Job otherJob) {
		boolean result = false;
		switch(type) {
			case EDF: result = (this.getDeadline() < otherJob.getDeadline()); break;
			case SPT: result = (this.getProcTime() < otherJob.getProcTime()); break;
			case ERT: result = (this.getRelease() < otherJob.getRelease());
		}
		return(result);
	}

	public boolean lessImportantThan(Job otherJob) { 
		return(!moreImportantThan(otherJob)); 
	}

	public static void switchPriorityType(Job[] jobArray, Job.PriorityType type) {
		for(int i = 0; i < jobArray.length; i++) {
			Job job = new Job(jobArray[i].getRelease(), jobArray[i].getDeadline(), jobArray[i].getProcTime(), type);
			jobArray[i] = job;
		}
	}

	private Job(int r, int d, int p, PriorityType t) { 
		release = r; deadline = d; 
		procTime = p; type = t;
	}

	private  PriorityType type;
	private int deadline;
	private int release;
	private int procTime;
}
