package br.com.unipe.aula.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public ModelAndView welcome() {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("mensagem", "View com parâmetro funcionando com sucesso!");
		return view;
	}
	
}
