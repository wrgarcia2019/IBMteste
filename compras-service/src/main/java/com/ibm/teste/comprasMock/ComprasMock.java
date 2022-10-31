package com.ibm.teste.comprasMock;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import com.ibm.teste.model.Compras;

@FeignClient(value = "compras", url="http://www.mocky.io/v2/")
public interface ComprasMock {
	
	@GetMapping(value = "/598b16861100004905515ec7")
	List<Compras> getCompras();
}
