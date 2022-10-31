package com.ibm.teste.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Itens {
	private String produto;
	private String variedade;
	private String pais;
	private String categoria;
	private String safra;
	private BigDecimal preco;
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
	public Itens() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, pais, preco, produto, safra, variedade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itens other = (Itens) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(pais, other.pais)
				&& Objects.equals(preco, other.preco) && Objects.equals(produto, other.produto)
				&& Objects.equals(safra, other.safra) && Objects.equals(variedade, other.variedade);
	}
	public Itens(String produto, String variedade, String pais, String categoria, String safra, BigDecimal preco) {
		super();
		this.produto = produto;
		this.variedade = variedade;
		this.pais = pais;
		this.categoria = categoria;
		this.safra = safra;
		this.preco = preco;
	}
	
}
