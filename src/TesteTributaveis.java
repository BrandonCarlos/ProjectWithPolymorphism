
public class TesteTributaveis {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		CalculadorDeImposto calculaImposto = new CalculadorDeImposto();
		calculaImposto.registra(seguro);
		calculaImposto.registra(cc);
		
		
		System.out.println(calculaImposto.getTotalImposto());
		
	}

}
