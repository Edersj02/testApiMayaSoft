/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testapimayasoft.models;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;

/**
 *
 * @author eder
 */
public class CharacterString {
    
    @Size(min = 1, max = 500)
    @NotNull
    private String chain;
    @Digits(integer = 3, fraction = 0)
    @NotNull
    private int subSize;

    public CharacterString() {
        super();
    }

    public CharacterString(String chain, int subSize) {
        super();
        this.chain = chain;
        this.subSize = subSize;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public int getSubSize() {
        return subSize;
    }

    public void setSubSize(int subSize) {
        this.subSize = subSize;
    }
    
    public Set<ConstraintViolation<CharacterString>> validated() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
