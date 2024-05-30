package br.com.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.estagio.entity.AlunoEntity;
import jakarta.transaction.Transactional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
	
	AlunoEntity getOneByIdAluno(Long idAluno);
	
	@Modifying
	 @Transactional
	 @Query(value = "insert into estagio.aluno_vaga (aluno_id, vaga_id) VALUES (:idAluno,:idVaga)", nativeQuery = true)
	 void candidatarVaga(@Param("idAluno") Long idAluno,
			 			 @Param("idVaga") Long idVaga
			 			 );

}
