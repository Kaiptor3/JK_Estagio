package br.com.estagio.service;

import java.util.List;

import br.com.estagio.entity.PermissaoEntity;

public interface PermissaoService {
	
	String save(PermissaoEntity permissaoEntity) throws Exception;
	List<PermissaoEntity> findAll();
	PermissaoEntity getOneByIdPermissao(Long idPermissao) throws Exception;
	String deleteById(Long idPermissao) throws Exception;
	
}
