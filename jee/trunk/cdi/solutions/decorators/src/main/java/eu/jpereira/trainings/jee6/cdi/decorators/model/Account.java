package eu.jpereira.trainings.jee6.cdi.decorators.model;

import java.io.Serializable;

public interface Account extends Serializable{

	public Float getBalance();

	public void withdraw(Float ammount) throws Exception;
}
