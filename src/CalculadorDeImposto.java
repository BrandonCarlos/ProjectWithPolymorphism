public class CalculadorDeImposto {
	private double totalImposto;

	public void registra(Tributavel t) {//tudo que assinou contrato com a interface "tributavel" podemos acessar
		//com este método	
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
}
