package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.model.Post;
import br.com.unipe.aula.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    @Autowired
    private PostService service;

    private static final String ENTITY = "posts";

    @GetMapping(value = {"", "/"})
    public ModelAndView findAll() {
        ModelAndView view = new ModelAndView();
        view.addObject(ENTITY, service.findAll());
        return view;
    }

}
