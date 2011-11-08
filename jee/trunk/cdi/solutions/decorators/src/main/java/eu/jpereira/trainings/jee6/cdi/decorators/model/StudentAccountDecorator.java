package eu.jpereira.trainings.jee6.cdi.decorators.model;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.decorators.model.qualifiers.StudentAccount;


@Decorator
public abstract class StudentAccountDecorator implements Account {

	
	private static final long serialVersionUID = -2923141502330585047L;
	private @Inject @Delegate @StudentAccount Account delegate;

	@Override
	public void withdraw(Float ammount) throws Exception {
		System.out.println("Withdrwaing from Student account the ammount of "+ammount);
		//check if the limit was reached
		if ( delegate.getBalance() - ammount <= 0 ) {
			throw new Exception("Insuficient funds");
		}
		delegate.withdraw(ammount);
	}

}
