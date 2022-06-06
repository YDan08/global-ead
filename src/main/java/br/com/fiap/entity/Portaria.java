package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gco_portaria")
@SequenceGenerator(name = "portaria", sequenceName = "sq_t_gco_portaria", allocationSize = 1)
public class Portaria implements Serializable{


	private static final long serialVersionUID = -1070818053436658707L;
	
	public Portaria() {
		
	}

	public Portaria(int numeroPortaria,String nome, Boolean status, LocalDate dataInicio, LocalDate dataTermino,
			Condominio condominio) {
		this();
		this.numeroPortaria = numeroPortaria;
		this.nome = nome;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.condominio = condominio;
	}

	@Id
	@Column(name = "id_portaria")
	@GeneratedValue(generator= "portaria", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nr_portaria")
	private int numeroPortaria;
	
	@Column(name = "nm_portaria")
	private String nome;
	
	@Column(name = "st_status")
	private Boolean status;

	@Column(name = "dt_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name = "dt_termino", nullable = false)
	private LocalDate dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "id_condominio")
	private Condominio condominio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroPortaria() {
		return numeroPortaria;
	}

	public void setNumeroPortaria(int numeroPortaria) {
		this.numeroPortaria = numeroPortaria;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	@Override
	public String toString() {
		return "Portaria [numeroPortaria=" + numeroPortaria + ", nome=" + nome + ", status=" + status + ", dataInicio="
				+ dataInicio + ", dataTermino=" + dataTermino + ", condominio=" + condominio + "]";
	}

	
	
	
}
