/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testapimayasoft.repository;

import com.example.testapimayasoft.models.CharacterString;
import com.example.testapimayasoft.models.ResponseApi;
import java.util.ArrayList;
import java.util.HashMap;
import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author eder
 */
public class CharacterStringRepository {

    public Response precessCharacters(CharacterString characters) {
        ArrayList<String> errors = new ArrayList<String>();
        for (ConstraintViolation error : characters.validated()) {
            errors.add(error.getMessage());
        }
        if (errors.size() > 0) {
            return respErr(errors, Response.Status.BAD_REQUEST);
        }
        String word = validateWordsSize(characters);
        if (!word.equals("")) {
            errors.add("La palabra: (" + word
                    + ") supera el tamaño establecido para la subcadena");
            return respErr(errors, Response.Status.BAD_REQUEST);
        }
                
        ArrayList<String> charactersArray = charactersToArray(
                characters.getChain(), characters.getSubSize());
        return respOk(charactersArray, Status.OK);
    }

    private String validateWordsSize(CharacterString characters) {
        String[] words = characters.getChain().split(" ");
        for (String word : words) {
            if (word.length() > characters.getSubSize()) {
                return word;
            }
        }
        return "";
    }

    private ArrayList<String> charactersToArray(String chain, int subSize) {

        ArrayList<String> charactersLists = new ArrayList<String>();
        String[] charsList = chain.split(" ");
        String newText = "";
        for (int i = 0; i < charsList.length; i++) {
            if ((newText.length() + charsList[i].length()) < subSize) {
                newText += charsList[i] + " ";
            } else {
                charactersLists.add(newText.trim());
                newText = "";
                newText = charsList[i] + " ";
            }
        }
        if (!newText.equals("")) {
            charactersLists.add(newText.trim());
        }
        return charactersLists;
    }
    
    private Response respOk(ArrayList<String> data, Status status) {
        
        ResponseApi resp = new ResponseApi();
        resp.setCode(status.getStatusCode());
        resp.setMessage("Texto procesado correctamente");
        resp.setError(new ArrayList<String>());
        resp.setData(data);
        
        return Response.status(status)
                    .entity(resp)
                    .build();
    }
    
    private Response respErr(ArrayList<String> errors, Status status) {
        
        ResponseApi resp = new ResponseApi();
        resp.setCode(status.getStatusCode());
        resp.setMessage("");
        resp.setError(errors);
        resp.setData(new ArrayList<String>());
        
        return Response.status(status)
                    .entity(resp)
                    .build();
    }

}
