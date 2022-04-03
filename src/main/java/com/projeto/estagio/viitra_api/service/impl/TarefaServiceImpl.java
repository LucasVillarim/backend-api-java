package com.projeto.estagio.viitra_api.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.estagio.viitra_api.DTO.TarefaDTO;
import com.projeto.estagio.viitra_api.database.MembroRepository;
import com.projeto.estagio.viitra_api.database.TarefasRepository;
import com.projeto.estagio.viitra_api.model.Membro;
import com.projeto.estagio.viitra_api.model.Tarefa;
import com.projeto.estagio.viitra_api.service.contrato.ITarefaService;

@Service
public class TarefaServiceImpl implements ITarefaService {

	private static final int PRIMEIRA_POSICAO = 0;

	@Autowired
	private TarefasRepository tarefasRepository;

	@Autowired
	private MembroRepository membroRepository;

	public void criarTarefa(TarefaDTO tarefa, String membroId) {
		Tarefa tarefaModel = new Tarefa();
		Calendar calendar = Calendar.getInstance();
		long dataHoraMilisegundos = calendar.getTimeInMillis();
		
		Membro donoDaTarefa = membroRepository.buscarMembroPeloEmail(membroId).get(PRIMEIRA_POSICAO);

		tarefaModel.setNome(tarefa.getNome());
		tarefaModel.setFinalizada(tarefa.isFinalizada());
		tarefaModel.setDescricao(tarefa.getDescricao());
		tarefaModel.setPrioridade(tarefa.getPrioridade());
		tarefaModel.setDataTermino(dataHoraMilisegundos);
		tarefaModel.setMembro(donoDaTarefa);

		tarefasRepository.save(tarefaModel);
	}

	public List<Tarefa> buscarTarefas() {
		return tarefasRepository.findAll();
	}

	public Tarefa buscarTarefaPeloId(Long tarefaId) {
		return tarefasRepository.findById(tarefaId).get();
	}

	public void removerTarefa(Long id) {
		tarefasRepository.deleteById(id);
	}

}
