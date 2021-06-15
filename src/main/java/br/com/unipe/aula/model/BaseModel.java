package br.com.unipe.aula.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseModel<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    protected T id;

    @Getter
    @Setter
    protected LocalDateTime dateRegister = LocalDateTime.now();

    @Getter
    @Setter
    protected LocalDateTime dateLastModified;

    @Getter
    @Setter
    protected boolean active = true;

}

