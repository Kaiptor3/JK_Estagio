package br.com.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estagio.entity.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
	
	EmpresaEntity getOneByIdEmpresa(Long idEmpresa);

}
