package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.AlunoEntity;
import br.com.estagio.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	private String mensagem;
	
	@Override
	public String save(AlunoEntity alunoEntity) throws Exception {
		
		if (alunoEntity.getNome() == null) {
			this.mensagem = "Digite o nome do aluno.";
			throw new Exception("Preencha o nome do aluno.");
			
		} else if (alunoEntity.getTelefone() == null){
			this.mensagem = "Digite o telefone do aluno.";
			throw new Exception("Preencha o telefone do aluno.");
		} else if (alunoEntity.getPeriodo() == null) {
			this.mensagem = "Digite o periodo do aluno.";
			throw new Exception("Preencha o periodo do aluno");
		} else if (alunoEntity.getEscola() == null) {
			this.mensagem = "Selecione a escola do aluno.";
			throw new Exception("Selecione a escola do aluno.");
		} else if (alunoEntity.getCurso() == null) {
			this.mensagem = "Selecione o curso do aluno.";
			throw new Exception("Selecione o curso do aluno.");
		} else {
			alunoRepository.saveAndFlush(alunoEntity);
			this.mensagem = "Aluno cadastrado com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<AlunoEntity> findAll() {
		
		return alunoRepository.findAll();
	}

	@Override
	public AlunoEntity getOneByIdAluno(Long idAluno) throws Exception {
		// TODO Auto-generated method stub
		return alunoRepository.getOneByIdAluno(idAluno);
	}

	@Override
	public String deleteById(Long idAluno) throws Exception {
		try
		{
			alunoRepository.deleteById(idAluno);
			this.mensagem = "Aluno Excluido com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

	@Override
	public void candidatarVaga(Long idAluno, Long idVaga) {
		// TODO Auto-generated method stub
		alunoRepository.candidatarVaga(idAluno, idVaga);
	}
	

}
