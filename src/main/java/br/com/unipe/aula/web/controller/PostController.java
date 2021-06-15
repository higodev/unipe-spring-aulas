package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.dto.PostCommentDTO;
import br.com.unipe.aula.dto.PostDTO;
import br.com.unipe.aula.model.Post;
import br.com.unipe.aula.model.PostComment;
import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.PostCommentService;
import br.com.unipe.aula.service.PostService;
import br.com.unipe.aula.service.UserService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private PostCommentService commentService;

    private static final String ENTITY = "posts";

    @GetMapping(value = "/list")
    public ModelAndView findAll(String... msg) {

        ModelAndView view = new ModelAndView(ENTITY + "/list");
        view.addObject(ENTITY, service.findAll());

        if (this.hasAlert) {
            view.addObject("message", getMessageSuccess(this.alert));
            this.hasAlert = false;
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

        this.hasAlert = true;
        User user = userService.findOne(obj.getCreatedBy());
        Post post = modelMapper.map(obj, Post.class);
        post.setCreatedBy(user);

        if (obj.getId() == null) {
            service.create(post);
            this.alert = "Registro salvo com sucesso!";
        } else {
            service.update(post);
            this.alert = "Registro atualizado com sucesso!";
        }

        return "redirect:list";
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
        this.hasAlert = true;
        service.deleteById(id);
        this.alert = "Registro excluído com sucesso!";
        return "redirect:../list";
    }


    @PostMapping(value = "/save-comments/{id}")
    public String create(@PathVariable("id") Long id, @ModelAttribute PostCommentDTO obj) {

        this.hasAlert = true;

        obj.setPost(id);
        Post post = service.findOne(obj.getPost());
        User user = userService.findOne(post.getCreatedBy().getId());

        PostComment comment = new PostComment();
        comment.setPost(post);
        comment.setCreatedBy(user);
        comment.setDescription(obj.getDescription());

        if (obj.getId() == null) {
            commentService.create(comment);
            this.alert = "Registro salvo com sucesso!";
        } else {
            commentService.update(comment);
            this.alert = "Registro atualizado com sucesso!";
        }

        return "redirect:list";
    }


}
