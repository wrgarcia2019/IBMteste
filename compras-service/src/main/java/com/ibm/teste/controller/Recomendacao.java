package com.ibm.teste.controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.teste.comprasMock.ComprasMock;
import com.ibm.teste.model.Compras;
import com.ibm.teste.model.Itens;
import com.ibm.teste.proxy.ClientesProxy;
import com.ibm.teste.suporte.recomendacao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Recomendação")
@RestController
@RequestMapping("recomendacao/cliente/tipo")
public class Recomendacao {

	@Autowired
	ComprasMock comprasMock;
	
	@Autowired
	ClientesProxy clientesProxy;
	
	int quantVendas = 0;
	int quantVendasItens;
	
	@Operation(summary = "Retorna recomendação por cpf de cliente baseado nas suas compras")
	@GetMapping
	public List<recomendacao> getRecomendacao() throws ParseException {
		
		List<Compras> compras = comprasMock.getCompras();
		List<Compras> ordemClientes = compras.stream()
				.sorted((v1,v2) -> 	v1.getCliente().compareTo(v2.getCliente()))
				.collect(Collectors.toList());
		ArrayList<recomendacao> myList = new ArrayList<>();
		boolean naoexiste = false;
		
		for (int i = 0; i < ordemClientes.size(); i++) {
			String cpfCliente = ordemClientes.get(i).getCliente();
			
			if (cpfCliente.length() > 14) {
				cpfCliente = cpfCliente.substring(1);
			}
			
			recomendacao record = pesquisaCompras(ordemClientes, cpfCliente);
			if (myList.isEmpty()) {
				myList.add(record);
			}
			for (recomendacao recomendacao : myList) {
				String cpf = recomendacao.getCpf();
				if (!cpf.equals(cpfCliente)) {
					naoexiste = true;
				}else {
					naoexiste = false;
					break;
				}
			}
			if (naoexiste == true) {
				naoexiste = false;
				myList.add(record);
			}
		}
		return myList;
	}
	
	public recomendacao pesquisaCompras(List<Compras> ordemClientes, String cpfCliente) { 
		List<Itens> ItensCompra = new ArrayList<>();
		List<Itens> todosItensCompra = new ArrayList<>();
		String cpfMaior = "";
		  for (int i = 0; i < ordemClientes.size(); i++) { 
			  	  String cpfCompra =  ordemClientes.get(i).getCliente().toString();
			  	  cpfMaior = "0" + cpfCliente;
			  	  
			  	  
			  	  if (cpfCompra.equals(cpfCliente) || cpfCompra.equals(cpfMaior)) { 
			  		  ItensCompra = ordemClientes.get(i).getItens();
			  		  todosItensCompra.addAll(ItensCompra);
			  	   } 
		  } 
		  recomendacao produtoCompra = this.pesquisaProdutoMaisConsumido(todosItensCompra);
		  produtoCompra.setCpf(cpfCliente);
		  
		  return produtoCompra;
		  
	  }
	
	  private recomendacao pesquisaProdutoMaisConsumido(List<Itens> itensCompra) {
		String categoriaAux = "";
		boolean naoexiste = false;
		ArrayList<recomendacao> myList = new ArrayList<>();
		for (int i = 0; i < itensCompra.size(); i++) {
			String categoria = itensCompra.get(i).getCategoria();
			Itens item = itensCompra.get(i);
			if (myList.isEmpty()) {
				quantVendasItens = 1;
				myList.add(new recomendacao(
						null,
						item.getProduto(),
						item.getVariedade(),
						item.getPais(),
						item.getCategoria(),
						item.getSafra(),
						item.getPreco(),
						quantVendasItens));
			}else {
				for (recomendacao recomendacao : myList) {
					categoriaAux = recomendacao.getCategoria();
					quantVendasItens = recomendacao.getQuantidadeCompras();
					if (categoriaAux.equals(categoria)) {
						quantVendasItens ++;
						recomendacao.setQuantidadeCompras(quantVendasItens);
					}else {
						naoexiste = true;
						
					}
				
				}
				if (naoexiste == true) {
					quantVendasItens = 1;
					naoexiste = false;
					myList.add(new recomendacao (
							null,
							item.getProduto(),
							item.getVariedade(),
							item.getPais(),
							item.getCategoria(),
							item.getSafra(),
							item.getPreco(),
							quantVendasItens));
					}
			}
		}
		int quantidadeAux = 0;
		int indice = 0;
		for (int i = 0; i < myList.size(); i++) {
			
			int quantidade = myList.get(i).getQuantidadeCompras();
			if (quantidade > quantidadeAux) {
				quantidadeAux = quantidade;
				indice = i;
			}
		}
		recomendacao rec = myList.get(indice); 	
		
		return rec;
	}
}
