public class ContaCorrente extends Conta implements Tributavel {
	//Com Herança herdamos "Atributos e métodos" menos o "constructor"
	public ContaCorrente(int agencia, int numero) {//está chamando o "Constructor" da "Classe Base"
		super(agencia, numero);//repassando estes argumentos para o Constructor especifico lá da class Conta
	}
	
	@Override //Sobreescrevendo o método
	public boolean saca(double valor) {
		double valorASacar = valor + 0.2;
		return super.saca(valorASacar);//Agora ao invés de enviar apenas o valor lá no método saca, vai enviar
		//o valorASacar que é o valor + 0.2 centavos, reaproveitamento de código
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}

}
