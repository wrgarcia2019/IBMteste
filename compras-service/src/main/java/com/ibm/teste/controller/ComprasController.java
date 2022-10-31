package com.ibm.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.teste.comprasMock.ComprasMock;

import com.ibm.teste.model.Compras;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "O Mock original de compras")
@RestController
@RequestMapping("comprasMock")
public class ComprasController {
	
	@Autowired
	ComprasMock comprasMock;
	
	@Operation(summary = "Retorna o Mock das compras")
	@GetMapping
	public List<Compras> getCompras() {
		return comprasMock.getCompras();
	}
}
