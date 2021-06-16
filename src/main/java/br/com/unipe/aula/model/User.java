package br.com.unipe.aula.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class User extends BaseModel<Long> implements Serializable {

	private static final long serialVersionUID = 4432797654111047262L;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(length = 200)
	private String local;
	
	@OneToMany(mappedBy = "createdBy")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "createdBy")
	private List<PostComment> postComments = new ArrayList<>();
	
}
