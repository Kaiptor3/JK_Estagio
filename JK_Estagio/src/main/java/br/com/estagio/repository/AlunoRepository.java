package br.com.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estagio.entity.AlunoEntity;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
	
	AlunoEntity getOneByIdAluno(Long idAluno);

}
