package br.com.estagio.service;

import java.util.List;

import br.com.estagio.entity.EmpresaEntity;

public interface EmpresaService {
	
	String save(EmpresaEntity empresaEntity) throws Exception;
	List<EmpresaEntity> findAll();
	EmpresaEntity getOneByIdEmpresa(Long idEmpresa) throws Exception;
	String deleteById(Long idEmpresa) throws Exception;
	
}