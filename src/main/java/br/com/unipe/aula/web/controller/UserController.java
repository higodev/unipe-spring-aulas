package br.com.unipe.aula.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.model.User;

@Controller
@RequestMapping(path = "/users")
public class UserController extends BaseController {

    private static final String ENTITY = "users";

    @GetMapping(value = "/list")
    public ModelAndView findAll(String...msg) {

        ModelAndView view = new ModelAndView(ENTITY + "/list");
        view.addObject(ENTITY, userService.findAll());

        if (this.alertActive) {
            view.addObject("message", getViewAlertMessage());
            this.alertActive = false;
        }

        return view;
    }

    @GetMapping(path = "/new")
    public ModelAndView newRecord(Model model) {
        model.addAttribute("obj", new User());
        return new ModelAndView(ENTITY + "/form");
    }

    @PostMapping(value = "/save")
    public String create(@ModelAttribute User obj) {

        this.alertActive = true;

        if (obj.getId() == null) {
            userService.create(obj);
            this.alertMessage = "Registro salvo com sucesso!";
        } else {
            userService.update(obj);
            this.alertMessage = "Registro atualizado com sucesso!";
        }

        return "redirect:list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView findById(@RequestParam(value = "id") Long id) {
        ModelAndView view = new ModelAndView(ENTITY + "/form");
        view.addObject("obj", userService.findOne(id));
        return view;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        this.alertActive = true;
        userService.deleteById(id);
        this.alertMessage = "Registro excluído com sucesso!";
        return "redirect:../list";
    }
}
