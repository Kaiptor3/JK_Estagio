package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.CursoEntity;
import br.com.estagio.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;
	
	private String mensagem;
	
	@Override
	public String save(CursoEntity cursoEntity) throws Exception {
		
		if (cursoEntity.getNome() == null) {
			this.mensagem = "Digite o nome do curso.";
			throw new Exception("Preencha o nome curso.");	
			
		} else if (cursoEntity.getPeriodo() == null) {
			this.mensagem = "Digite o periodo do curso.";
			throw new Exception("Preencha o periodo do curso.");	
		} else {
			cursoRepository.saveAndFlush(cursoEntity);
			this.mensagem = "Curso cadastrado com sucesso";
		}
		return mensagem;
	}
	
	@Override
	public List<CursoEntity> findAll() {
		
		return cursoRepository.findAll();
	}
	
	@Override
	public CursoEntity getOneByIdCurso(Long idCurso) throws Exception {
		
		return cursoRepository.getOneByIdCurso(idCurso);
	}
	
	@Override
	public String deleteById(Long idCurso) throws Exception {
		try
		{
			cursoRepository.deleteById(idCurso);
			this.mensagem = "Curso Excluido com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
