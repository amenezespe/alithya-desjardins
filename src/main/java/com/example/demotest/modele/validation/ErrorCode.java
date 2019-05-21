package com.example.demotest.modele.validation;

public enum ErrorCode {


    CHAINE_VIDE("10001", "La chaine de characteres ne peux pas etre vide."),
    GRANDEUR_MAXIMALE("10002", "La grandeur maximale de la chaine de caracteres est 30."),
    INTERNAL_ERROR("99999", "Une erreur interne se produit.");


    private String errorCode;
    private String message;

    ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
