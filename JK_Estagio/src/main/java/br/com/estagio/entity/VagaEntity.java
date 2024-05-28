package br.com.estagio.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaga", schema = "estagio")
public class VagaEntity implements Serializable{

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vaga")
	private Long idVaga;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valor_bolsa")
	private String valorBolsa;

	@Column(name = "beneficios")
	private String beneficios;

	@Column(name = "curso")
	private String curso;
	
	@Column(name = "empresa_id", insertable=false, updatable=false)
	private Long empresaId;
	
	@OneToOne()
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_empresa")
    private EmpresaEntity empresa;
	
	@ManyToMany(mappedBy = "vagas",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<AlunoEntity> alunos;

	public Long getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Long idVaga) {
		this.idVaga = idVaga;
	}

	public String getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(String valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "VagaEntity [nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVaga);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VagaEntity other = (VagaEntity) obj;
		return Objects.equals(idVaga, other.idVaga);
	}	
	
	
	
	
}
