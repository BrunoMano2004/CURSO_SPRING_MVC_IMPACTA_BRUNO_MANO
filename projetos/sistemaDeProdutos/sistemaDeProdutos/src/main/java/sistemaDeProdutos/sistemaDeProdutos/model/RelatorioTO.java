package sistemaDeProdutos.sistemaDeProdutos.model;

import java.util.Objects;

public class RelatorioTO {
	
	private double valorTotalProdutos;
	private double menorValorProduto;
	private double maiorValorProduto;
	
	public RelatorioTO() {
		super();
	}
	
	public double getValorTotalProdutos() {
		return valorTotalProdutos;
	}
	public void setValorTotalProdutos(double valorTotalProdutos) {
		this.valorTotalProdutos = valorTotalProdutos;
	}
	public double getMenorValorProduto() {
		return menorValorProduto;
	}
	public void setMenorValorProduto(double menorValorProduto) {
		this.menorValorProduto = menorValorProduto;
	}
	public double getMaiorValorProduto() {
		return maiorValorProduto;
	}
	public void setMaiorValorProduto(double maiorValorProduto) {
		this.maiorValorProduto = maiorValorProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maiorValorProduto, menorValorProduto, valorTotalProdutos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelatorioTO other = (RelatorioTO) obj;
		return Double.doubleToLongBits(maiorValorProduto) == Double.doubleToLongBits(other.maiorValorProduto)
				&& Double.doubleToLongBits(menorValorProduto) == Double.doubleToLongBits(other.menorValorProduto)
				&& Double.doubleToLongBits(valorTotalProdutos) == Double.doubleToLongBits(other.valorTotalProdutos);
	}
}
