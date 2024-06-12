package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.VagaEntity;
import br.com.estagio.repository.VagaRepository;

@Service
public class VagaServiceImpl implements VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	private String mensagem;
	
	@Override
	public String save(VagaEntity vagaEntity) throws Exception {
		
		if (vagaEntity.getNome() == null) {
			this.mensagem = "Digite o nome da vaga.";
			throw new Exception("Preencha o nome da vaga.");
			
		} else if (vagaEntity.getValorBolsa() == null){
			this.mensagem = "Digite o valor da bolsa.";
			throw new Exception("Preencha o valor da bolsa");
		} else if (vagaEntity.getBairro() == null) {
			this.mensagem = "Digite o bairro da vaga.";
			throw new Exception("Preencha o bairro da vaga.");
		} else if (vagaEntity.getCurso() == null) {
			this.mensagem = "Digite o curso";
			throw new Exception("Preencha o curso");
		} else {
			vagaRepository.saveAndFlush(vagaEntity);
			this.mensagem = "Vaga cadastrada com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<VagaEntity> findAll() {

		return vagaRepository.findAll();
	}

	@Override
	public VagaEntity getOneByIdVaga(Long idVaga) throws Exception {
		
		return vagaRepository.getOneByIdVaga(idVaga);
	}

	@Override
	public String deleteById(Long idVaga) throws Exception {
		try
		{
			vagaRepository.deleteById(idVaga);
			this.mensagem = "Vaga Excluida com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

	@Override
	public VagaEntity getOneByEmpresaId(Long idEmpresa) throws Exception {
		
		return vagaRepository.getOneByEmpresaId(idEmpresa);
	}

}
