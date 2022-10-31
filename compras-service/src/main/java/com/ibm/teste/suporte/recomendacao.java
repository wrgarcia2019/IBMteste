package com.ibm.teste.suporte;

import java.math.BigDecimal;
import java.util.Objects;

public class recomendacao {

	private String cpf;
	private String produto;
	private String variedade;
	private String pais;
	private String categoria;
	private String safra;
	private BigDecimal preco;
	private int quantidadeCompras;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getVariedade() {
		return variedade;
	}
	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSafra() {
		return safra;
	}
	public void setSafra(String safra) {
		this.safra = safra;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public int getQuantidadeCompras() {
		return quantidadeCompras;
	}
	public void setQuantidadeCompras(int quantidadeCompras) {
		this.quantidadeCompras = quantidadeCompras;
	}
	public recomendacao(String cpf, String produto, String variedade, String pais, String categoria, String safra,
			BigDecimal preco, int quantidadeCompras) {
		super();
		this.cpf = cpf;
		this.produto = produto;
		this.variedade = variedade;
		this.pais = pais;
		this.categoria = categoria;
		this.safra = safra;
		this.preco = preco;
		this.quantidadeCompras = quantidadeCompras;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, cpf, pais, preco, produto, quantidadeCompras, safra, variedade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		recomendacao other = (recomendacao) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(pais, other.pais) && Objects.equals(preco, other.preco)
				&& Objects.equals(produto, other.produto) && quantidadeCompras == other.quantidadeCompras
				&& Objects.equals(safra, other.safra) && Objects.equals(variedade, other.variedade);
	}
		
	
}
