package com.projeto.estagio.viitra_api.service.contrato;

import java.util.List;

import com.projeto.estagio.viitra_api.DTO.TarefaDTO;
import com.projeto.estagio.viitra_api.model.Tarefa;

public interface ITarefaService {

	void criarTarefa(TarefaDTO tarefa, String membroId);
	
	List<Tarefa> buscarTarefas();
	
	Tarefa buscarTarefaPeloId(Long tarefaId);
	
	void removerTarefa(Long id);
}
