package br.com.unipe.aula.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController extends BaseController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("mensagem", "");
		return view;
	}
	
}
