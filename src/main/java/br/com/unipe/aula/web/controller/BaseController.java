package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected UserService userService;

    protected String alert;

    protected boolean hasAlert;

    protected String getMessageSuccess(String message) {
        return "<div class=\"alert alert-success\" role=\"alert\">" + message + "</div>";
    }
}
