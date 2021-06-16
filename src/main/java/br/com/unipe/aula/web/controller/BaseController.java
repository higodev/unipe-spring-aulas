package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

  @Autowired
  protected ModelMapper modelMapper;

  @Autowired
  protected UserService userService;

  protected String alertType = "success";
  protected String alertMessage = "Operação realizada com sucesso!";
  protected boolean alertActive;

  protected String getViewAlertMessage() {
    return "<div class=\"alert alert-" + alertType + "\" role=\"alert\">" + alertMessage + "</div>";
  }

}
