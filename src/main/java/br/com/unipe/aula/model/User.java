package br.com.unipe.aula.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User extends BaseModel<Long> implements Serializable {

	private static final long serialVersionUID = 4432797654111047262L;

	@Column(length = 100)
	private String name;

	@Column(length = 200)
	private String local;
	
	@OneToMany(mappedBy = "createdBy")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "createdBy")
	private List<PostComment> postComments = new ArrayList<>();
	
}
