package eu.jpereira.trainings.jee6.cdi.events.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.events.beans.Lottery;
import eu.jpereira.trainings.jee6.cdi.events.events.LotteryResult;
import eu.jpereira.trainings.jee6.cdi.events.qualifiers.ResultAvaiable;


@Decorator
public abstract class LotteryDecorator implements Lottery {

	private @Inject @Delegate @Any Lottery delegate;
	
	private @Inject @ResultAvaiable Event<LotteryResult> resultGeneratedEvent;
	
	@Override
	public void generateResult() {
		delegate.generateResult();
		resultGeneratedEvent.fire(new LotteryResult(delegate.getResult()));
		
	}

}
