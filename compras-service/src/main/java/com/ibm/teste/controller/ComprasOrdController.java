package com.ibm.teste.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.teste.comprasMock.ComprasMock;
import com.ibm.teste.model.Compras;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Compras por ordem de valor")
@RestController
@RequestMapping("compras")
public class ComprasOrdController {

	@Autowired
	ComprasMock comprasMock;
	
	@Operation(summary = "Retorna todas as compras por valor em ordem crescente")
	@GetMapping
	public List<Compras> getOrdenarCompras() {
		List<Compras> desord = comprasMock.getCompras();
		return desord.stream().sorted((v1,v2) ->
		v1.getValorTotal().compareTo(v2.getValorTotal()))
		.collect(Collectors.toList());
	}
}
