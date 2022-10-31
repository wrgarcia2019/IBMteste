package com.ibm.teste.suporte;

import java.math.BigDecimal;
import java.util.Objects;

public class top implements Comparable<top>{
	private String cpf;
	private String name;
	private int quantVendas;
	private BigDecimal maiorValor;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantVendas() {
		return quantVendas;
	}
	public void setQuantVendas(int quantVendas) {
		this.quantVendas = quantVendas;
	}
	public BigDecimal getMaiorValor() {
		return maiorValor;
	}
	public void setMaiorValor(BigDecimal maiorValor) {
		this.maiorValor = maiorValor;
	}
	public top() {
		super();
	}
	public top(String cpf, String name, int quantVendas, BigDecimal maiorValor) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.quantVendas = quantVendas;
		this.maiorValor = maiorValor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, maiorValor, name, quantVendas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		top other = (top) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(maiorValor, other.maiorValor)
				&& Objects.equals(name, other.name) && quantVendas == other.quantVendas;
	}
	@Override
	public int compareTo(top o) {
		if (this.getQuantVendas() > o.getQuantVendas()) 
		{   
			return -1;   
		}
		
		if (this.getQuantVendas() < o.getQuantVendas()) 
		{   
			return 1;   
		}
			
		return 0;
	}
	
	
}
