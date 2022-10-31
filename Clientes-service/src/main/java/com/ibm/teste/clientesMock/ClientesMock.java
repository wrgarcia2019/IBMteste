package com.ibm.teste.clientesMock;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ibm.teste.model.Clientes;

@FeignClient(value = "clientes", url="http://www.mocky.io/v2/")
public interface ClientesMock {

	@GetMapping(value = "/598b16291100004705515ec5")
	List<Clientes> getClientes();
}
