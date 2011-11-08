package eu.jpereira.trainings.jee6.cdi.decorators.model;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class ThiefAccountDecorator implements Account{

	
	private static final long serialVersionUID = 9123683784034862888L;
	private @Inject @Delegate @Any Account delegate;

	@Override
	public void withdraw(Float ammount) throws Exception {
		System.out.println("Withdrwaing funds from some account :"+ammount+"...ammount will still 0.001 for my account :)");
		delegate.withdraw(ammount+0.001f);
	}

}
