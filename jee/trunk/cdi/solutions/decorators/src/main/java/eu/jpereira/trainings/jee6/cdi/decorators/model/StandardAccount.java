package eu.jpereira.trainings.jee6.cdi.decorators.model;

import javax.annotation.PostConstruct;




@eu.jpereira.trainings.jee6.cdi.decorators.model.qualifiers.StandardAccount
public class StandardAccount implements Account {

	
	private static final long serialVersionUID = -226614265995737208L;
	protected Float balance;
	public static final Float DEFAULT_BALANCE = 100f;
	
	@Override
	public Float getBalance() {
		
		return this.balance;
	}
	
	@Override
	public void withdraw(Float ammount) throws Exception {
		this.balance -= ammount;

	}
	
	
	@SuppressWarnings("unused")
	@PostConstruct
	private void initialize() {
		System.out.println("Initializing "+this.getClass().getName());
		this.balance = DEFAULT_BALANCE ;
		
	}

}
