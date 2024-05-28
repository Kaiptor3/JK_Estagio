package br.com.estagio.service;

import java.util.List;

import br.com.estagio.entity.VagaEntity;

public interface VagaService {
	
	String save(VagaEntity vagaEntity) throws Exception;
	List<VagaEntity> findAll();
	VagaEntity getOneByIdVaga (Long idVaga) throws Exception;
	String deleteById(Long idVaga) throws Exception;
	VagaEntity getOneByEmpresaId(Long empresaId) throws Exception;
	

}
