package com.example.demotest.modele.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChaineValidateur extends BaseConstraintValidator implements ConstraintValidator<ChaineValide, String> {

    @Override
    public void initialize(ChaineValide constraintAnnotation) {
       //pas de traitement ici
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        setConstraintValidator(constraintValidatorContext);

        var erreur = validateChaineCharactere(s);

        if (erreur != null) {
            setMessage(erreur.getErrorCode(), erreur.getMessage());
            return false;
        }

        return true;
    }

    private ErrorCode validateChaineCharactere (String chaine) {

        if (StringUtils.isEmpty(chaine)){

            return ErrorCode.CHAINE_VIDE;
        }

        if (chaine.length()>30){

            return ErrorCode.GRANDEUR_MAXIMALE;
        }

        return null;
    }
}
