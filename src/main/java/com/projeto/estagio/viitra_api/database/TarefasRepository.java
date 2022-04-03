package com.projeto.estagio.viitra_api.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projeto.estagio.viitra_api.model.Tarefa;

public interface TarefasRepository extends CrudRepository<Tarefa, Long> {

	List<Tarefa> findAll();
	
}
