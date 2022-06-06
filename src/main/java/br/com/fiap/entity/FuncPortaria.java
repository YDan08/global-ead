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
@Table(name = "t_gco_func_portaria")
@SequenceGenerator(name = "funcPortaria", sequenceName = "sq_t_gco_func_portaria", allocationSize = 1)
public class FuncPortaria implements Serializable{

	private static final long serialVersionUID = -2793300312853782059L;
	
	public FuncPortaria() {
		
	}
	
	

	public FuncPortaria(String nome, LocalDateTime dataNascimento, String cpf, String rg, LocalDateTime dataCadastro) {
		this();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
	}



	@Id
	@Column(name = "id_func_portaria")
	@GeneratedValue(generator = "funcPortaria", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nm_funcionario")
	private String nome;
	
	@Column(name = "dt_nasc", nullable = false)
	private LocalDateTime dataNascimento;

	@Column(name = "nr_cpf")
	private String cpf;

	@Column(name = "nr_rg")
	private String rg;

	@Column(name = "dt_cadastro", nullable = false)
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

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	@Override
	public String toString() {
		return "FuncPortaria [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", rg=" + rg
				+ ", dataCadastro=" + dataCadastro + "]";
	}

	
}
