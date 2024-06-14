package br.com.estagio.service;

import java.util.List;

import br.com.estagio.entity.UsuarioEntity;

public interface UsuarioService {
	
	UsuarioEntity getOneByCpf(String cpf);
	String save(UsuarioEntity usuarioEntity) throws Exception;
	List<UsuarioEntity> findAll();
	UsuarioEntity getOneByIdUsuario(Long idUsuario) throws Exception;
	String deleteById(Long idUsuario) throws Exception;

}
