package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.entity.Condominio;
import br.com.fiap.entity.FuncPortaria;
import br.com.fiap.entity.MovimentacaoPortaria;
import br.com.fiap.entity.Portaria;
import br.com.fiap.entity.Visitante;
import br.com.fiap.service.impl.CondominioServiceImpl;
import br.com.fiap.service.impl.FuncPortariaServiceImpl;
import br.com.fiap.service.impl.MovimentacaoPortariaServiceImpl;
import br.com.fiap.service.impl.PortariaServiceImpl;
import br.com.fiap.service.impl.VisitanteServiceImpl;

public class App {

	public static void main(String[] args) {
		
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		FuncPortariaServiceImpl funcPortariaService = FuncPortariaServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		MovimentacaoPortariaServiceImpl movimentoService = MovimentacaoPortariaServiceImpl.getInstance();
		
		System.out.println("============ Cadastro de condominio ==============");
		Condominio condominio =  new Condominio("12345","Condominio Fiap","Condominio Fiap",LocalDate.of(2022, 1, 1));
		condominioService.cadastrar(condominio);
		
		System.out.println("============ Cadastro de Portaria ==============");
		Portaria portaria =  new Portaria(1,"Principal",true,LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 7), condominio);
		Portaria portaria2 =  new Portaria(2,"Serviço",true,LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 7), condominio);
		portariaService.cadastrar(portaria);
		portariaService.cadastrar(portaria2);
		
		System.out.println("============ Cadastro de movimento ==============");
		FuncPortaria func1 = funcPortariaService.obter(1L);
		FuncPortaria func2 = funcPortariaService.obter(2L);
		Visitante visitante1 = visitanteService.obter(1L);
		Visitante visitante2 = visitanteService.obter(2L);
		MovimentacaoPortaria movimento1 =  new MovimentacaoPortaria("E",LocalDateTime.of(2022, 6, 1, 15, 0, 0,0),portaria,func1,visitante1);
		MovimentacaoPortaria movimento2 =  new MovimentacaoPortaria("E",LocalDateTime.of(2022, 6, 1, 15, 30, 0,0),portaria,func1,visitante2);
		MovimentacaoPortaria movimento3 =  new MovimentacaoPortaria("S",LocalDateTime.of(2022, 6, 1, 15, 45, 0,0),portaria,func2,visitante1);
		movimentoService.cadastrar(movimento1);
		movimentoService.cadastrar(movimento2);
		movimentoService.cadastrar(movimento3);
				
		System.out.println("============ Listar Movimento por Tipo ==============");
		movimentoService.ListarPorTipo("E");
		
		System.out.println("============ Listar Visitantes por filtro ==============");
		visitanteService.pesquisar("maria", null, null);
		
	}
}
