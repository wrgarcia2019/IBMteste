package com.ibm.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.teste.clientesMock.ClientesMock;
import com.ibm.teste.model.Clientes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes")
@RestController
@RequestMapping("clientes")
public class ClientesController {
	
	@Autowired
	ClientesMock clientesMock;
	
	@Operation(summary = "Retorna o Mock de Clientes")
	@GetMapping
	public List<Clientes> getClientes() {
		return clientesMock.getClientes();
	}
}
