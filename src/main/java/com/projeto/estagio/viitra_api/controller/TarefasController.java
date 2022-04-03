package com.projeto.estagio.viitra_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.estagio.viitra_api.DTO.TarefaDTO;
import com.projeto.estagio.viitra_api.model.Tarefa;
import com.projeto.estagio.viitra_api.service.impl.TarefaServiceImpl;

@RestController
@RequestMapping("/api/tarefas")
public class TarefasController {

	@Autowired
	private TarefaServiceImpl tarefaService;

	@GetMapping
	public ResponseEntity<?> buscarTarefas() {
		return new ResponseEntity<>(tarefaService.buscarTarefas(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarTarefaPeloId(@PathVariable(value = "id") Long tarefaId) {
		try {
		Tarefa tarefa = tarefaService.buscarTarefaPeloId(tarefaId);
		return new ResponseEntity<>(tarefa, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{membroId}/criar")
	public ResponseEntity<Void> postCriarTarefa(@RequestBody TarefaDTO tarefa,
			@PathVariable(value = "membroId") String membroId) {
		try {
			tarefaService.criarTarefa(tarefa, membroId);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}/deletar")
	public ResponseEntity<Void> deleteTarefa(@PathVariable(value = "id") Long id) {
		try {
			tarefaService.removerTarefa(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
