package eu.jpereira.trainings.jee.mdb.topics.model.jobs;



public class ProcessOrderJob extends Job {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8298306812099489929L;


	
	public static class Builder extends Job.Builder<Job>{

		@Override
		protected ProcessOrderJob createInstance() {
			return new ProcessOrderJob();
		}
		
	}
	

}
