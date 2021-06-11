package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/form")
	public ModelAndView viewForm(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("formulario");
	}

	@PostMapping("/formulario")
	public ModelAndView viewWithMessage(@ModelAttribute User user) {
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", user.getName() + " é morador de " + user.getLocal());
		return view;
	}

	@GetMapping(value = "/cadastro")
	public ModelAndView viewFormAndFindAll(@ModelAttribute User user) {
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Sucesso!");
		view.addObject("moradores", service.findAll());
		return view;
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView findById(@PathVariable("id") Long id, Model model) {
		ModelAndView view = new ModelAndView("editar");
		view.addObject("morador", service.findOne(id));
		return view;
	}

	@PostMapping(value = "/cadastro")
	public ModelAndView create(@ModelAttribute User user) {
		service.create(user);
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Morador " + user.getName() + " cadastrado com sucesso!");
		view.addObject("moradores", service.findAll());
		return view;
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@PathVariable("id") Long id, User morador) {
		service.update(morador);
		return "redirect:../cadastro";
	}

	@GetMapping(value = "/excluir/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		service.deleteById(id);
		return "redirect:../cadastro";
	}
}
