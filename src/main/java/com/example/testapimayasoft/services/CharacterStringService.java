/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testapimayasoft.services;

import com.example.testapimayasoft.models.CharacterString;
import com.example.testapimayasoft.repository.CharacterStringRepository;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author eder
 */
@Path("characters")
public class CharacterStringService {

    private CharacterStringRepository repository;
    
    public CharacterStringService() {
        repository = new CharacterStringRepository();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChain() {
        CharacterString characters = new CharacterString("Hola Mundo", 79);
        return Response.ok(characters).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response precessCharacters(CharacterString characters) {
        return repository.precessCharacters(characters);
    }
}
