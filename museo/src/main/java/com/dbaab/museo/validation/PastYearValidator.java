package com.dbaab.museo.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dbaab.museo.validation.annotations.PastYear;

public class PastYearValidator implements ConstraintValidator<PastYear, Integer>
{
    private boolean pastOrPresent;

    @Override
    public void initialize(PastYear constraintAnnotation)
    {
        this.pastOrPresent = constraintAnnotation.pastOrPresent();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context)
    {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        return this.pastOrPresent ? value <= currentYear : value < currentYear;
    }
}
