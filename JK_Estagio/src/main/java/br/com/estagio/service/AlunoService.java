package br.com.estagio.service;

import java.util.List;



import br.com.estagio.entity.AlunoEntity;



public interface AlunoService {
	
	String save(AlunoEntity alunoEntity) throws Exception;
	List<AlunoEntity> findAll();
	AlunoEntity getOneByIdAluno (Long idAluno) throws Exception;
	String deleteById(Long idAluno) throws Exception;
	public void candidatarVaga(Long idAluno, Long idVaga);
}