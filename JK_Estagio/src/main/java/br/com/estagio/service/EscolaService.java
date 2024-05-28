package br.com.estagio.service;

import java.util.List;

import br.com.estagio.entity.EscolaEntity;

public interface EscolaService {
	
	String save(EscolaEntity escolaEntity) throws Exception;
	List<EscolaEntity> findAll();
	EscolaEntity getOneByIdEscola(Long idEscola) throws Exception;
	String deleteById(Long idEscola) throws Exception;
	
}
