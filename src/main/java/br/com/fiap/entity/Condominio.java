package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_condominio")
@SequenceGenerator(name = "condominio", sequenceName = "sq_t_gco_condominio", allocationSize = 1)
public class Condominio implements Serializable {

	private static final long serialVersionUID = -6349332855171321954L;
	
	public Condominio() {
	}

	public Condominio(String cnpj, String razaoSocial, String fantasia, LocalDate dataFundacao) {
		this();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.dataFundacao = dataFundacao;
	}


	@Id
	@Column(name = "id_condominio")
	@GeneratedValue(generator = "condominio", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nr_cnpj")
	private String cnpj;

	@Column(name = "ds_razao_social")
	private String razaoSocial;

	@Column(name = "nm_fantasia")
	private String fantasia;

	@Column(name = "dt_fundacao", nullable = false)
	private LocalDate dataFundacao;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public String toString() {
		return "Condominio [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", fantasia=" + fantasia
				+ ", dataFundacao=" + dataFundacao + "]";
	}
	
	

}
