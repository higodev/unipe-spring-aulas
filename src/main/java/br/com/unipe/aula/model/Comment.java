package br.com.unipe.aula.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 5930053041224144056L;
	
	@ManyToOne
	private Post post;
	
	@Column(nullable = true, length = 100)
	private String description;

}
