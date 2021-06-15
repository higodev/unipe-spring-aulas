package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/users")
public class UserController extends BaseController {

    private static final String ENTITY = "users";

    @GetMapping(value = "/list")
    public ModelAndView findAll(String...msg) {

        ModelAndView view = new ModelAndView(ENTITY + "/list");
        view.addObject(ENTITY, userService.findAll());

        if (this.hasAlert) {
            view.addObject("message", getMessageSuccess(this.alert));
            this.hasAlert = false;
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

        this.hasAlert = true;

        if (obj.getId() == null) {
            userService.create(obj);
            this.alert = "Registro salvo com sucesso!";
        } else {
            userService.update(obj);
            this.alert = "Registro atualizado com sucesso!";
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
        this.hasAlert = true;
        userService.deleteById(id);
        this.alert = "Registro excluído com sucesso!";
        return "redirect:../list";
    }
}
