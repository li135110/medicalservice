package com.tk.medical.exceptions;


import lombok.Data;

@Data
public class BaseException extends RuntimeException {

    private String massage;
    private Object object;

    public BaseException(String massage) {

    }

    public BaseException(String massage, Object object) {

    }
}
