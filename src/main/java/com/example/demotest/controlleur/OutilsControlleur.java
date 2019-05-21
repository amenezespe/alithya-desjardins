package com.example.demotest.controlleur;

import com.example.demotest.modele.validation.ChaineValide;
import com.example.demotest.services.ChaineStringOutil;
import com.example.demotest.services.NumeroOutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Validated
public class OutilsControlleur {

    @Autowired
    private ChaineStringOutil serviceChaineString;


    @Autowired
    private NumeroOutil serviceNumero;

    @GetMapping(value="/stringDedup", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getFilterTrierString(@ChaineValide @RequestParam(value = "value") String chaine)  {

        return new ResponseEntity<>(serviceChaineString.ordeneUniqueChaineString(chaine), HttpStatus.OK);
    }

    @GetMapping(value="/writeNumber", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getConverterNumero(@Min(0) @Max(999999) @RequestParam("value") int numero) {

        return new ResponseEntity<>(serviceNumero.converterNumero(numero), HttpStatus.OK);
    }
}
