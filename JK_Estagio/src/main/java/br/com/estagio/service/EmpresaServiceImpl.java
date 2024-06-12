package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.EmpresaEntity;
import br.com.estagio.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private String mensagem;
	
	@Override
	public String save(EmpresaEntity empresaEntity) throws Exception {
		
		if (empresaEntity.getNome() == null) {
			this.mensagem = "Digite o nome da empresa.";
			throw new Exception("Preencha o nome da empresa.");	
		} {
			empresaRepository.saveAndFlush(empresaEntity);
			this.mensagem = "Empresa cadastrado com sucesso";
		}
		return mensagem;
	}
	
	@Override
	public List<EmpresaEntity> findAll() {
		
		return empresaRepository.findAll();
	}
	
	@Override
	public EmpresaEntity getOneByIdEmpresa(Long idEmpresa) throws Exception {
		
		return empresaRepository.getOneByIdEmpresa(idEmpresa);
	}
	
	@Override
	public String deleteById(Long idEmpresa) throws Exception {
		try
		{
			empresaRepository.deleteById(idEmpresa);
			this.mensagem = "Empresa Excluida com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}