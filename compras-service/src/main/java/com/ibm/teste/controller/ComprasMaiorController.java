package com.ibm.teste.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.teste.comprasMock.ComprasMock;
import com.ibm.teste.model.Compras;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Maior compra")
@RestController
@RequestMapping("maior-compra/")
public class ComprasMaiorController {
	
	@Autowired
	ComprasMock comprasMock;
	@Operation(summary = "Retorna a maior compra pelo ano")
	@GetMapping(value = "/{ano}")
	public Compras getMaiorCompras(
			@PathVariable("ano") String ano) {
				List<Compras> desord = comprasMock.getCompras();
				List<Compras> valorMaior = desord.stream().sorted((v1,v2) ->
				v1.getValorTotal().compareTo(v2.getValorTotal()))
						.collect(Collectors.toList());
				int index = 0;
				for (int i = 0; i < valorMaior.size(); i++) {
					String dataFormatada = valorMaior.get(i).getData();
					if (dataFormatada.contains(ano)) {
						index = i;
					}
				}
				
				Compras maiorCompra = valorMaior.get(index);	
				return maiorCompra;
			}
}
