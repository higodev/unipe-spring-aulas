package br.com.unipe.aula.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentDTO {
    private Long id;
    private Long post;
    private String description;
    private Long createdBy;
}
