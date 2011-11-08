package eu.jpereira.trainings.jee6.cdi.events.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;




@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
		ElementType.TYPE })

public @interface RandomNumber {
	@Nonbinding int max() default 50;
	@Nonbinding int min() default 0;
}
