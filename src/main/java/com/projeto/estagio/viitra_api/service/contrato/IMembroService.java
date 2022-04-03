package com.projeto.estagio.viitra_api.service.contrato;

import com.projeto.estagio.viitra_api.DTO.MembroDTO;
import com.projeto.estagio.viitra_api.model.Membro;

public interface IMembroService {

	void criarMembro(MembroDTO membro);
	
	Object buscarMembro(String membroEmail);
	
	void removerMembro(Long id);
	
	Membro buscarPeloId(Long id);
}
