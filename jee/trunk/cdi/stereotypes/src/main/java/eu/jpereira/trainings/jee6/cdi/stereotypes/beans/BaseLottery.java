package eu.jpereira.trainings.jee6.cdi.stereotypes.beans;



public abstract class BaseLottery implements Lottery{

	protected String result;
	@Override
	public String getResult() {
		return this.result;
	}

}
