package com.dbaab.museo.errorManagement;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorManager implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}