package br.com.estagio.service;

import java.util.List;


import br.com.estagio.entity.CursoEntity;

public interface CursoService {
	
	String save(CursoEntity cursoEntity) throws Exception;
	List<CursoEntity> findAll();
	CursoEntity getOneByIdCurso(Long idCurso) throws Exception;
	String deleteById(Long idCurso) throws Exception;
	
}
