package model;

import java.util.ArrayList;

public class Estoque {
	private long idEstoque;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public long getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(long idEstoque) {
		this.idEstoque = idEstoque;
	}
}
