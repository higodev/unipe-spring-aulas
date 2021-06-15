package br.com.unipe.aula.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String descriptionTitle;
    private String descriptionSubTitle;
    private String descriptionBody;
    private Long createdBy;
}
