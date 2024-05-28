package br.com.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estagio.entity.EscolaEntity;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaEntity, Long> {
	
	EscolaEntity getOneByIdEscola(Long idEscola);

}

