package eu.jpereira.trainings.jee6.cdi.events.stereotypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;

import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedElapsedTime;
import eu.jpereira.trainings.jee6.cdi.events.bindings.LoggedParameters;


@Stereotype
@LoggedElapsedTime
@LoggedParameters
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE })
public @interface LoggedFull {
}
