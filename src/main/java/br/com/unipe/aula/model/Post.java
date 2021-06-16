package br.com.unipe.aula.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "posts")
public class Post extends BaseModel<Long> implements Serializable{
	
	private static final long serialVersionUID = -5751971415990666818L;

	@Column(length = 250)
	private String descriptionTitle;

	@Column(length = 250)
	private String descriptionSubTitle;
	
	@Column(length = 5000)
	private String descriptionBody;

	@ManyToOne(fetch = FetchType.EAGER)
	private User createdBy;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<PostComment> comments = new ArrayList<>();
	
}
