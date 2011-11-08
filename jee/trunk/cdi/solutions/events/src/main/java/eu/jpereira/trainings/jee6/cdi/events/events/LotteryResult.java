package eu.jpereira.trainings.jee6.cdi.events.events;

public class LotteryResult {

	private String result;
	public LotteryResult(String result) {
		this.result = result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
	}
	
}
