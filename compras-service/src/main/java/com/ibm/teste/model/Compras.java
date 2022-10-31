package com.ibm.teste.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Compras {
	private String codigo;
	private String data;
	private String cliente;
	private List<Itens> itens;
	private BigDecimal valorTotal;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public List<Itens> getItens() {
		return itens;
	}
	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Compras() {
		super();
	}
	public Compras(String codigo, String data, String cliente, List<Itens> itens, BigDecimal valorTotal) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
		this.valorTotal = valorTotal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, codigo, data, itens, valorTotal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compras other = (Compras) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(data, other.data) && Objects.equals(itens, other.itens)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
	
	
	
}
