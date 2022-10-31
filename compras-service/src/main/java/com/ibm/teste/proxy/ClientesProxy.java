package com.ibm.teste.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.teste.response.Clientes;


@FeignClient(name = "clientes", url="http://localhost:8080/clientes")
public interface ClientesProxy {

	@RequestMapping(method = RequestMethod.GET, value = "")
	List<Clientes> getClientes();
}


