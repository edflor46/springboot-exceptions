package com.yahikko.springboot.exceptions.springbootexceptions.models;

import java.util.Date;

import lombok.Data;

@Data
public class Error {

    private String message;
    private String error;
    private Integer status;
    private Date Date;


}
