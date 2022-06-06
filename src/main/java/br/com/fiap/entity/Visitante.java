package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_visitante")
@SequenceGenerator(name = "visitante", sequenceName = "sq_t_gco_visitante", allocationSize = 1)
public class Visitante implements Serializable {
 

	private static final long serialVersionUID = -755117022887794957L;

	public Visitante() {
		
	}
	
	public Visitante(String nome, LocalDateTime dataNascimento, String cpf, String rg, LocalDateTime dataCadastro) {
		this();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}



	@Id
	@Column(name = "id_visitante")
	@GeneratedValue(generator = "visitante", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nm_visitante")
	private String nome;
	
	@Column(name = "dt_nasc", nullable = false)
	private LocalDateTime dataNascimento;

	@Column(name = "nr_cpf")
	private String cpf;
	
	@Column(name = "nr_rg")
	private String rg;

	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



	@Override
	public String toString() {
		return "Visitante [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", rg=" + rg
				+ ", dataCadastro=" + dataCadastro + "]";
	}

	


}
