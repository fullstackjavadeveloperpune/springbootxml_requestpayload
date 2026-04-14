package com.fullstack.exception;

import javax.management.RuntimeMBeanException;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String msg){
        super(msg);
    }

}
