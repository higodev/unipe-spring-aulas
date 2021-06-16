package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.dto.PostDTO;
import br.com.unipe.aula.model.Post;
import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/posts")
public class PostController extends BaseController {

  @Autowired
  private PostService service;

  private static final String ENTITY = "posts";

  @GetMapping(value = "/list")
  public ModelAndView findAll(String... msg) {

    ModelAndView view = new ModelAndView(ENTITY + "/list");
    view.addObject(ENTITY, service.findAll());

    if (this.alertActive) {
      view.addObject("message", getViewAlertMessage());
      this.alertActive = false;
    }
    return view;
  }

  @GetMapping(path = "/new")
  public ModelAndView newRecord(Model model) {
    model.addAttribute("obj", new PostDTO());
    model.addAttribute("users", userService.findAll());
    return new ModelAndView(ENTITY + "/form");
  }

  @PostMapping(value = "/save")
  public String create(@ModelAttribute PostDTO obj) {
    try {
      this.alertActive = true;
      User user = userService.findOne(obj.getCreatedBy());
      Post post = modelMapper.map(obj, Post.class);
      post.setCreatedBy(user);

      if (obj.getId() == null) {
        service.create(post);
        this.alertType = "success";
        this.alertMessage = "Registro salvo com sucesso!";
      } else {
        service.update(post);
        this.alertType = "info";
        this.alertMessage = "Registro atualizado com sucesso!";
      }

    } catch (Exception e) {
      this.alertType = "danger";
      this.alertMessage = "Ops! Algo deu errado. Erro: " + e.getMessage();
    } finally {
      return "redirect:list";
    }
  }

  @GetMapping(value = "/edit")
  public ModelAndView findById(@RequestParam(value = "id") Long id) {
    ModelAndView view = new ModelAndView(ENTITY + "/form");
    Post post = service.findOne(id);
    PostDTO postDTO = new PostDTO(
        post.getId(),
        post.getDescriptionTitle(),
        post.getDescriptionSubTitle(),
        post.getDescriptionBody(),
        post.getCreatedBy().getId()
    );
    view.addObject("obj", postDTO);
    view.addObject("users", userService.findAll());
    return view;
  }

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    try {
      this.alertActive = true;
      service.deleteById(id);
      this.alertMessage = "Registro excluído com sucesso!";
    } catch (Exception e) {
      this.alertType = "danger";
      this.alertMessage = "Ops! Algo deu errado. Erro: " + e.getMessage();
    } finally {
      return "redirect:../list";
    }
  }
}
