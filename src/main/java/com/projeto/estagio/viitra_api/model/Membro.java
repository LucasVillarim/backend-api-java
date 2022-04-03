package com.projeto.estagio.viitra_api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "membros")
public class Membro {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @OneToMany(
            mappedBy = "membro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonIgnoreProperties("membro")
    private List<Tarefa> tarefas = new ArrayList<>();
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Size(min = 5)
    private String nome;

    @Column(nullable = false)
    private String senha;

}
