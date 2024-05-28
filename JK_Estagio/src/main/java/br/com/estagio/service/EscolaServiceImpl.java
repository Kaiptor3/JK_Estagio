package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.EscolaEntity;
import br.com.estagio.repository.EscolaRepository;

@Service
public class EscolaServiceImpl implements EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	private String mensagem;

	@Override
	public String save(EscolaEntity escolaEntity) throws Exception {
		
		if (escolaEntity.getEmail() == null) {
			this.mensagem = "Digite o email da escola.";
			throw new Exception("Preencha o email da escola.");
			
		} else if (escolaEntity.getNome() == null){
			this.mensagem = "Digite o nome da escola.";
			throw new Exception("Preencha o nome da escola.");

		} else if (escolaEntity.getEstado() == null) {
			this.mensagem = "Digite o estado da escola.";
			throw new Exception("Preencha o estado da escola.");
			
		} else if (escolaEntity.getBairro() == null){
			this.mensagem = "Digite o bairro da escola.";
			throw new Exception("Preencha o bairro da escola.");
			
		} else if (escolaEntity.getRua() == null) {
			this.mensagem = "Digite a rua da escola.";
			throw new Exception("Preencha a rua da escola.");
			
		} else if (escolaEntity.getNumero() == null) {
			this.mensagem = "Digite o numero da escola.";
			throw new Exception("Preencha o numero da escola.");
		} else {
			escolaRepository.saveAndFlush(escolaEntity);
			this.mensagem = "Escola cadastrada com sucesso";
		}
		return mensagem;
	}
	


	@Override
	public List<EscolaEntity> findAll() {
		
		return escolaRepository.findAll();
	}

	@Override
	public EscolaEntity getOneByIdEscola(Long idEscola) throws Exception {
		
		return escolaRepository.getOneByIdEscola(idEscola);
	}
	
	@Override
	public String deleteById(Long idEscola) throws Exception {
		try
		{
			escolaRepository.deleteById(idEscola);
			this.mensagem = "Escola Excluido com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}
}
