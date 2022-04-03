package com.projeto.estagio.viitra_api.controller;

import java.util.List;

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

import com.projeto.estagio.viitra_api.DTO.MembroDTO;
import com.projeto.estagio.viitra_api.database.MembroRepository;
import com.projeto.estagio.viitra_api.model.Membro;
import com.projeto.estagio.viitra_api.service.impl.MembroServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private MembroServiceImpl membroService;

	@GetMapping
	public List<Membro> buscarTodos() {
		return (List<Membro>) membroRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Membro> buscarUsuarioPeloId(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(membroService.buscarPeloId(id), HttpStatus.OK);
	}

	@GetMapping("/buscar/{email}")
	public ResponseEntity<List<Membro>> getBuscarMembroPeloEmail(@PathVariable(value = "email") String email) {
		List<Membro> membros = membroRepository.buscarMembroPeloEmail(email);
		return new ResponseEntity<>(membros, HttpStatus.OK);
	}

	@PostMapping("/criar")
	public ResponseEntity<Void> salvarMembro(@RequestBody MembroDTO membro) {
		try {
			membroService.criarMembro(membro);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> deleteMembro(@PathVariable Long id) {
		try {
			membroService.removerMembro(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
