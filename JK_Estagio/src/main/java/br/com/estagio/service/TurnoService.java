package br.com.estagio.service;

import java.util.List;

import br.com.estagio.entity.TurnoEntity;

public interface TurnoService {
	
	List<TurnoEntity> findAll();
	TurnoEntity getOneByIdTurno(Long idTurno) throws Exception;

}
