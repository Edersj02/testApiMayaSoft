/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testapimayasoft.models;

import java.util.ArrayList;

/**
 *
 * @author eder
 */
public class ResponseApi {
    private int code;
    private String message;
    private ArrayList<String> error;
    private ArrayList<String> data;

    public ResponseApi() {
        super();
    }

    public ResponseApi(int code, String message, ArrayList<String> error, ArrayList<String> data) {
        super();
        this.code = code;
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getError() {
        return error;
    }

    public void setError(ArrayList<String> error) {
        this.error = error;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
        
}
