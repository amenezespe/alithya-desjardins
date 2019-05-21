package com.example.demotest.modele.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChaineValidateur.class)
public @interface ChaineValide {

    String message() default "La chaine de character n'est pas valide";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
