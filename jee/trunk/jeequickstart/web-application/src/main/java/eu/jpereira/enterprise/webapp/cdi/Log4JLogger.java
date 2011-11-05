package eu.jpereira.enterprise.webapp.cdi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;


import javax.inject.Qualifier;





@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,METHOD,FIELD,PARAMETER})
public @interface Log4JLogger  {

}
