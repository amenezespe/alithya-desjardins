package com.example.demotest.services;

import com.example.demotest.modele.ResponseRequette;
import org.springframework.stereotype.Service;

@Service
public class NumeroOutilImpl implements NumeroOutil {

    @Override
    public ResponseRequette converterNumero(int numero) {
        ResponseRequette response = new ResponseRequette();

        response.setContenu(converterNumeroEnChiffre(numero));

        return response ;
    }

    private String converterNumeroEnChiffre(int num) {

        int numero = num;

        String unitesArray[] = { "zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };


        String dizainesArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety" };


        String numeroEnChiffre = "";

        if (numero == 0) {
            return "zero";
        }

        if ((numero / 1000000) > 0) {
            return " numero invalide ";
        }

        if ((numero / 1000) > 0) {
            numeroEnChiffre += converterNumeroEnChiffre(numero / 1000) + " thousand ";
            numero %= 1000;
        }

        if ((numero / 100) > 0) {
            numeroEnChiffre += converterNumeroEnChiffre(numero / 100) + " hundred ";
            numero %= 100;
        }

        if (numero > 0) {

            if (numero < 20) {

                numeroEnChiffre += unitesArray[numero];
            } else {

                numeroEnChiffre += dizainesArray[numero / 10];
                if ((numero % 10) > 0) {
                    numeroEnChiffre += " " + unitesArray[numero % 10];
                }
            }
        }

        return numeroEnChiffre;

    }

}
