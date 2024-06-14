package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.TurnoEntity;
import br.com.estagio.repository.TurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService{
	
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public List<TurnoEntity> findAll() {
		// TODO Auto-generated method stub
		return turnoRepository.findAll();
	}

	@Override
	public TurnoEntity getOneByIdTurno(Long idTurno) throws Exception {
		// TODO Auto-generated method stub
		return turnoRepository.getOneByIdTurno(idTurno);
	}
}
