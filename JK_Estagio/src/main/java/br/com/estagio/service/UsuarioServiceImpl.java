package br.com.estagio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagio.entity.UsuarioEntity;
import br.com.estagio.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioEntity getOneByCpf(String cpf) {
		
		return usuarioRepository.getOneByCpf(cpf);
	}

}
