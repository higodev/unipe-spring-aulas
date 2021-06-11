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

import br.com.unipe.aula.dao.IGenericDAO;
import br.com.unipe.aula.model.Morador;

@Controller
@RequestMapping("/morador")
public class MoradorController {

  IGenericDAO<Morador> dao;

  @Autowired
  public void setDao(IGenericDAO<Morador> daoToSet) {
     dao = daoToSet;
     dao.setClazz(Morador.class);
  }
  
	@GetMapping("/formulario")
	public ModelAndView viewForm(Model model) {
		model.addAttribute("morador", new Morador());
		return new ModelAndView("formulario");
	}

	@PostMapping("/formulario")
	public ModelAndView viewWithMessage(@ModelAttribute Morador morador) {
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", morador.getNome() + " é morador de " + morador.getLocal());
		return view;
	}

	@GetMapping(value = "/cadastro")
	public ModelAndView viewFormAndFindAll(@ModelAttribute Morador morador) {
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Sucesso!");
		view.addObject("moradores", dao.findAll());
		return view;
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView findById(@PathVariable("id") Long id, Model model) {
		ModelAndView view = new ModelAndView("editar");
		view.addObject("morador", dao.findOne(id));
		return view;
	}

	@PostMapping(value = "/cadastro")
	public ModelAndView create(@ModelAttribute Morador morador) {
		dao.create(morador);
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Morador " + morador.getNome() + " cadastrado com sucesso!");
		view.addObject("moradores", dao.findAll());
		return view;
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@PathVariable("id") Long id, Morador morador) {
		dao.update(morador);
		return "redirect:../cadastro";
	}

	@GetMapping(value = "/excluir/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		dao.deleteById(id);
		return "redirect:../cadastro";
	}
}
