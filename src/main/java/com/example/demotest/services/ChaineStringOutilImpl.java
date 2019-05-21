package com.example.demotest.services;

import com.example.demotest.modele.ResponseRequette;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChaineStringOutilImpl implements ChaineStringOutil {


    @Override
    public ResponseRequette ordeneUniqueChaineString(String chaine) {

        return transformerListeEnChar(transformerChaineListe(chaine).stream().distinct().sorted().collect(Collectors.toList()));
    }

    private List<String> transformerChaineListe(String chaine) {

        List<String> listeResult = new ArrayList<>();
        char chaineChar[] = chaine.toCharArray();

        for ( char c : chaineChar) {

            listeResult.add(String.valueOf(c));
        }

        return listeResult;
    }

    private ResponseRequette transformerListeEnChar(List<String> liste) {

        var response = new ResponseRequette();

        String chaine = "";

        for (int i = 0; i < liste.size(); i++) {

            chaine += liste.get(i);
        }
        response.setContenu(chaine);

        return response;
    }

}
