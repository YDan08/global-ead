package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "t_gco_movimentacao_portaria")
@SequenceGenerator(name = "movimentacaoPortaria", sequenceName = "sq_t_gco_movimentacao_portaria", allocationSize = 1)
public class MovimentacaoPortaria implements Serializable{


	private static final long serialVersionUID = -1666724524722913022L;
	
	public MovimentacaoPortaria() {
		
	}
	
	

	public MovimentacaoPortaria(String tipo, LocalDateTime data, Portaria portaria, FuncPortaria funcPortaria,
			Visitante visitante) {
		this();
		this.tipo = tipo;
		this.data = data;
		this.portaria = portaria;
		this.funcPortaria = funcPortaria;
		this.visitante = visitante;
	}



	@Id
	@Column(name = "id_movimentacao")
	@GeneratedValue(generator = "movimentacaoPortaria", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "tp_movimentacao")
	private String tipo;

	@Column(name = "dt_movimentacao", nullable = false)
	private LocalDateTime data;
	
	@ManyToOne
	@JoinColumn(name = "id_portaria")
	private Portaria portaria;
	
	@ManyToOne
	@JoinColumn(name = "id_func_portaria")
	private FuncPortaria funcPortaria;
	
	@ManyToOne
	@JoinColumn(name = "id_visitante")
	private Visitante visitante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getData() {
		return data;
	}



	public void setData(LocalDateTime data) {
		this.data = data;
	}



	public Portaria getPortaria() {
		return portaria;
	}



	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}



	public FuncPortaria getFuncPortaria() {
		return funcPortaria;
	}



	public void setFuncPortaria(FuncPortaria funcPortaria) {
		this.funcPortaria = funcPortaria;
	}



	public Visitante getVisitante() {
		return visitante;
	}



	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}



	@Override
	public String toString() {
		return "MovimentacaoPortaria [tipo=" + tipo + ", data=" + data + ", portaria=" + portaria + ", funcPortaria="
				+ funcPortaria + ", visitante=" + visitante + "]";
	}

}
