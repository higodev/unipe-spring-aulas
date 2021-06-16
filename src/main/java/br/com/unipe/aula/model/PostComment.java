package br.com.unipe.aula.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "posts_comments")
public class PostComment extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = -8704267478774919392L;
	
	@ManyToOne
	private Post post;
	
	@Column(nullable = false, length = 100)
	private String description;

	@ManyToOne
	private User createdBy;
}
