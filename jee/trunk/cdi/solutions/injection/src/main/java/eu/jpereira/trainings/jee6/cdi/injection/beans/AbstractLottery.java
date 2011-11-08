package eu.jpereira.trainings.jee6.cdi.injection.beans;

public abstract class AbstractLottery implements Lottery{
	protected String result;
	@Override
	public String getResult() {
		return this.result;
	}

}
