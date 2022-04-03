package com.projeto.estagio.viitra_api.DTO;

import lombok.Data;

@Data
public class TarefaDTO {

	public String nome;
	public String descricao;
	public boolean finalizada;
	public String dataTermino;
	public String prioridade;
}
