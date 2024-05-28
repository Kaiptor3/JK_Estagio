package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.PermissaoEntity;
import br.com.estagio.repository.PermissaoRepository;

@Service
public class PermissaoServiceImpl implements PermissaoService {
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	private String mensagem;
	
	@Override
	public String save(PermissaoEntity permissaoEntity) throws Exception {
		
		if (permissaoEntity.getNome() == null) {
			this.mensagem = "Digite o nome da permissão.";
			throw new Exception("Preencha o nome da permissãoo.");
			
		} else {
			permissaoRepository.saveAndFlush(permissaoEntity);
			this.mensagem = "Permissão cadastrada com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<PermissaoEntity> findAll() {
		// TODO Auto-generated method stub
		return permissaoRepository.findAll();
	}

	@Override
	public PermissaoEntity getOneByIdPermissao(Long idPermissao) throws Exception {
		// TODO Auto-generated method stub
		return permissaoRepository.getOneByIdPermissao(idPermissao);
	}

	@Override
	public String deleteById(Long idPermissao) throws Exception {
		try
		{
			permissaoRepository.deleteById(idPermissao);
			this.mensagem = "Permissão Excluida com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}
	
	

}
