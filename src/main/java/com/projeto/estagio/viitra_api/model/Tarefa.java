package com.projeto.estagio.viitra_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Tarefa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("tarefas")
	private Membro membro;

	@Column(nullable = false, length = 50)
	@Size(min = 5, max = 50)
	private String nome;
	
	@Column(length = 140)
	private String descricao;

	@Column(nullable = false)
	private boolean finalizada;
	
	private Long dataTermino;

	@Column(nullable = false, columnDefinition = "varchar(10) default 'Baixa'")
	private String prioridade;
	
}
