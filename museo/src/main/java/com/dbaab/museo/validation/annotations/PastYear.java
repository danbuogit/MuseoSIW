package com.dbaab.museo.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.dbaab.museo.validation.PastYearValidator;

/**
 * The annotated element must be a integer number representing an year in the past.
 * @author Alessandro Attard Barbini
 */
@Target(value = { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastYearValidator.class)
public @interface PastYear
{
    String message() default "{com.dbaab.museo.validation.annotations.PastYear.message}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
    /**
     * Whether the year can be the present year as well, or not. (default is {@code false})
     * @return {@code true} if it can; {@code false} otherwise.
     */
    boolean pastOrPresent() default false;
}
