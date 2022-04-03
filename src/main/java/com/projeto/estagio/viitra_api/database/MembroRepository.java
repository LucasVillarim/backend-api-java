package com.projeto.estagio.viitra_api.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.estagio.viitra_api.model.Membro;

@Repository
public interface MembroRepository extends CrudRepository<Membro, Long> {

	List<Membro> buscarMembroPeloEmail(String email);
	
}
