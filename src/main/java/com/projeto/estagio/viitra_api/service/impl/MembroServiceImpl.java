package com.projeto.estagio.viitra_api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.estagio.viitra_api.DTO.MembroDTO;
import com.projeto.estagio.viitra_api.database.MembroRepository;
import com.projeto.estagio.viitra_api.model.Membro;
import com.projeto.estagio.viitra_api.service.contrato.IMembroService;

@Service
public class MembroServiceImpl implements IMembroService {
	
	@Autowired
	private MembroRepository membroRepository;
	
	public void criarMembro(MembroDTO membro) {
		Membro membroModel = new Membro();
		membroModel.setNome(membro.nome);
		membroModel.setEmail(membro.email);
		membroModel.setSenha(membro.senha);
		
		membroRepository.save(membroModel);
	}
	
	public Object buscarMembro(String membroEmail) {
		
		return null;
	}
	
	public void removerMembro(Long id) {
		membroRepository.deleteById(id);
	}

	public Membro buscarPeloId(Long id) {

		Optional<Membro> membro = membroRepository.findById(id);
		
		return membro.get();
	}
}
