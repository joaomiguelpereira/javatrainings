package eu.jpereira.trainings.jee6.cdi.producers.beans;

public abstract class AbstractLottery implements Lottery{
	protected String result;
	@Override
	public String getResult() {
		return this.result;
	}

}
