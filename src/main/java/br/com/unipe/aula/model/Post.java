package br.com.unipe.aula.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = -5751971415990666818L;

	@Column(length = 50)
	private String title;

	@Column(length = 100)
	private String subtitle;
	
	@Column(nullable = true, length = 1000)
	private String body;

	@ManyToOne
	private User createdBy;
	
	@OneToMany(mappedBy = "post")
	private List<PostComment> comments = new ArrayList<>();
	
}
