package br.com.estagio.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "escola", schema = "estagio")
public class EscolaEntity implements Serializable{

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_escola")
	private Long idEscola;

	@Column(name = "email")
	private String email;

	@Column(name = "nome")
	private String nome;

	@Column(name = "estado")
	private String estado;

	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "numero")
	private String numero;

	public Long getIdEscola() {
		return idEscola;
	}

	public void setIdEscola(Long idEscola) {
		this.idEscola = idEscola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
}
