package br.com.unipe.aula.web.controller;

import br.com.unipe.aula.dto.PostCommentDTO;
import br.com.unipe.aula.dto.PostDTO;
import br.com.unipe.aula.model.Post;
import br.com.unipe.aula.model.PostComment;
import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.PostCommentService;
import br.com.unipe.aula.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/comments")
public class PostCommentController extends BaseController {

  @Autowired
  private PostService service;

  @Autowired
  private PostCommentService commentService;

  @PostMapping(value = "/save/{id}")
  public String createComments(@PathVariable("id") Long id, @ModelAttribute PostCommentDTO obj) {
    try {
      this.alertActive = true;
      obj.setPost(id);
      Post post = service.findOne(obj.getPost());
      User user = userService.findOne(obj.getCreatedBy());

      PostComment comment = new PostComment();
      comment.setPost(post);
      comment.setCreatedBy(user);
      comment.setDescription(obj.getDescription());

      if (obj.getId() == null) {
        commentService.create(comment);
        this.alertMessage = "Comentário realizado com sucesso!";
      } else {
        commentService.update(comment);
        this.alertMessage = "Comentário atualizado com sucesso!";
      }
    } catch (Exception e) {
      this.alertType = "danger";
      this.alertMessage = "Ops! Algo deu errado. Erro: " + e.getMessage();
    } finally {
      return "redirect:/home";
    }
  }

  @GetMapping(value = "/delete/{id}")
  public String deleteComments(@PathVariable("id") Long id) {
    try {
      this.alertActive = true;
      commentService.deleteById(id);
      this.alertMessage = "Comentário excluído com sucesso!";
    } catch (Exception e) {
      this.alertType = "danger";
      this.alertMessage = "Ops! Algo deu errado. Erro: " + e.getMessage();
    } finally {
      return "redirect:/home";
    }
  }
}
