package br.com.unipe.aula.web.controller;

public abstract class BaseController {

    protected String alert;
    protected boolean hasAlert;

    protected String getMessageSuccess(String message) {
        return "<div class=\"alert alert-success\" role=\"alert\">" + message + "</div>";
    }
}
