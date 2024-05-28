package br.com.estagio.service;

import br.com.estagio.entity.UsuarioEntity;

public interface UsuarioService {
	
	UsuarioEntity getOneByCpf(String cpf);

}
