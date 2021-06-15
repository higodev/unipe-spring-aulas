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
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService service;

    private boolean isRedirect;

    @GetMapping(value = "/list")
    public ModelAndView findAll(@ModelAttribute User user) {
        ModelAndView view = new ModelAndView("users/list");
        view.addObject("users", service.findAll());
        if (this.isRedirect) {
            view.addObject("message", "Registro salvo com sucesso!");
            this.isRedirect = false;
        }
        return view;
    }

    @GetMapping(path = "/new")
    public ModelAndView viewForm(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("users/form");
    }

    @PostMapping(value = "/save")
    public String create(@ModelAttribute User user) {
        service.create(user);
        this.isRedirect = true;
        return "redirect:list";
    }

    @PostMapping("/formulario")
    public ModelAndView viewWithMessage(@ModelAttribute User user) {
        ModelAndView view = new ModelAndView("users/formulario");
        view.addObject("mensagem", "Registro salvo com sucesso!");
        return view;
    }

    @GetMapping(value = "/editar/{id}")
    public ModelAndView findById(@PathVariable("id") Long id, Model model) {
        ModelAndView view = new ModelAndView("users/editar");
        view.addObject("user", service.findOne(id));
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
