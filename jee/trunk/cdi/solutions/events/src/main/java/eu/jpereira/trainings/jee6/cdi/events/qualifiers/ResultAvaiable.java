package eu.jpereira.trainings.jee6.cdi.events.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({  ElementType.FIELD, ElementType.PARAMETER })
public @interface ResultAvaiable {

}
