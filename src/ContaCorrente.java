public class ContaCorrente extends Conta implements Tributavel {
	//Com Heran�a herdamos "Atributos e m�todos" menos o "constructor"
	public ContaCorrente(int agencia, int numero) {//est� chamando o "Constructor" da "Classe Base"
		super(agencia, numero);//repassando estes argumentos para o Constructor especifico l� da class Conta
	}
	
	@Override //Sobreescrevendo o m�todo
	public boolean saca(double valor) {
		double valorASacar = valor + 0.2;
		return super.saca(valorASacar);//Agora ao inv�s de enviar apenas o valor l� no m�todo saca, vai enviar
		//o valorASacar que � o valor + 0.2 centavos, reaproveitamento de c�digo
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
