package br.com.estagio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.UsuarioEntity;
import br.com.estagio.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private String mensagem;
	
	@Override
	public UsuarioEntity getOneByCpf(String cpf) {
		
		return usuarioRepository.getOneByCpf(cpf);
	}

	@Override
	public String save(UsuarioEntity usuarioEntity) throws Exception {
		
		if (usuarioEntity.getNome() == null) {
			this.mensagem = "Digite o nome da usuario.";
			throw new Exception("Preencha o nome da usuario.");
			
		} else if (usuarioEntity.getCpf() == null) {
			this.mensagem = "Digite o cpf do usuario.";
			throw new Exception("Preencha o cpf do usuario.");
			
		} else if (usuarioEntity.getSenha() == null) {
			this.mensagem = "Digite a senha do usuario.";
			throw new Exception("Preencha a senha do usuario.");
			
		} else {
			usuarioRepository.saveAndFlush(usuarioEntity);
			this.mensagem = "Usuario cadastrado com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<UsuarioEntity> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioEntity getOneByIdUsuario(Long idUsuario) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.getOneByIdUsuario(idUsuario);
	}

	@Override
	public String deleteById(Long idUsuario) throws Exception {
		try
		{
			usuarioRepository.deleteById(idUsuario);
			this.mensagem = "Usuario Excluida com sucesso";
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
