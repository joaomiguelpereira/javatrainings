package eu.jpereira.trainings.jee6.cdi.decorators.model;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.decorators.model.qualifiers.GoodAccount;


@Decorator
public abstract class GoodAccountDecorator implements Account {
	
	
	private static final long serialVersionUID = -1768041255891118584L;
	private @Inject @Delegate @GoodAccount Account delegate;

	@Override
	public void withdraw(Float ammount) throws Exception {
		System.out.println("Withdrwaing from Good account the ammount of "+ammount);
		if ( delegate.getBalance()-ammount <= -100 ) {
			throw new Exception("Max Credit exceeded...");
		}
		
		delegate.withdraw(ammount);
		
	}

}
