package com.ibm.teste.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.teste.comprasMock.ComprasMock;
import com.ibm.teste.model.Compras;
import com.ibm.teste.proxy.ClientesProxy;
import com.ibm.teste.response.Clientes;
import com.ibm.teste.suporte.top;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes-fieis")
@RestController
@RequestMapping("clientes-fieis")
public class ComprasClientesFieis {

	@Autowired
	ComprasMock comprasMock;
	
	@Autowired
	ClientesProxy clientesProxy;
	int quantVendas = 0;
	@Operation(summary = "Retorna os tres clientes mais fiéis")
	@GetMapping
	public List<top> getCompras() {
		List<Compras> compras = comprasMock.getCompras();
		List<Clientes> clientes = clientesProxy.getClientes();
		List<Compras> ordemClientes = compras.stream()
				.sorted((v1,v2) -> 	v1.getCliente().compareTo(v2.getCliente()))
				.collect(Collectors.toList());
		String melhorClienteAux = "";
		ArrayList<top> myList = new ArrayList<>();
		
		for (int i = 0; i < ordemClientes.size(); i++) {
			String cpfCliente = ordemClientes.get(i).getCliente();
			
			if (cpfCliente.length() > 14) {
				cpfCliente = cpfCliente.substring(1);
			}
			String name = pesquisaName(clientes, cpfCliente);
			BigDecimal maiorValor = ordemClientes.get(i).getValorTotal();
			
			if (cpfCliente.equals(melhorClienteAux)) {
				 quantVendas ++;
				 maiorValor = verificaMaiorValor(myList,maiorValor,cpfCliente);
				 removeTop(myList,cpfCliente);
				 myList.add(new top(cpfCliente,name,quantVendas,maiorValor));
			}else {
			     quantVendas = 1;
			     melhorClienteAux = cpfCliente;
				 myList.add(new top(cpfCliente,name,quantVendas,maiorValor));
			}
		}
		Collections.sort(myList);
		List<top> limit = myList.stream().limit(3).toList();
		List<top> maiorValorMyList = limit.stream()
				.sorted((v1,v2) -> 	v2.getMaiorValor().compareTo(v1.getMaiorValor()))
				.collect(Collectors.toList());
		return maiorValorMyList;
	}
	
	public void removeTop(ArrayList<top> myList, String cpfCliente) {
		for (int i = 0; i < myList.size(); i++) {
			String cpf = myList.get(i).getCpf().toString();
			cpf = cpf.replace('-', '.');
			if (cpfCliente.equals(cpf)) {
				myList.remove(i);
			}
		}
	}
	
	public String pesquisaName(List<Clientes> clientes, String cpfClientes) {
		for (int i = 0; i < clientes.size(); i++) {
			String cpf = clientes.get(i).getCpf().toString();
			cpf = cpf.replace('-', '.');
			if (cpfClientes.equals(cpf)) {
				return clientes.get(i).getNome().toString();
			}
		}
		return " ";
	}
	
	public BigDecimal verificaMaiorValor(ArrayList<top> myList, BigDecimal maiorValor, String cpfCliente) {
		for (int i = 0; i < myList.size(); i++) {
			String cpf = myList.get(i).getCpf().toString();
			cpf = cpf.replace('-', '.');
			if (cpfCliente.equals(cpf)) {
				BigDecimal valor = myList.get(i).getMaiorValor();
				if (valor.compareTo(maiorValor) == 1) {
					return valor;
				}
			}
		}
		return maiorValor;
	}
}
