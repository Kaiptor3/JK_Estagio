package br.com.estagio.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turno", schema = "estagio")
public class TurnoEntity implements Serializable{

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_turno")
private Long idTurno;

@Column(name = "nome")
private String nome;

public Long getIdTurno() {
	return idTurno;
}

public void setIdTurno(Long idTurno) {
	this.idTurno = idTurno;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}




}
