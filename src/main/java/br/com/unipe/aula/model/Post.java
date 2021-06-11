package br.com.unipe.aula.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable{
	
	private static final long serialVersionUID = -5751971415990666818L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, length = 50)
	private String title;

	@Column(nullable = true, length = 100)
	private String subtitle;
	
	@Column(nullable = true, length = 1000)
	private String body;
	
	@Column(nullable = false)
	private LocalDate createdIn = LocalDate.now();
	
	@ManyToOne
	private User createdBy;
	
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	
}
