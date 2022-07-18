public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;//total � "static", agora n�o � de cada objeto, e sim da classe Conta, tem um pouquinho
	//de cara de v�riavel GLOBAL aos objetos, agora todos os OBJETOS tem acesso a um �nico "total"
	
	//Se n�o reclararmos este constructor v�zio, o pr�prio java implementa para n�s, constructor default
	public Conta(int agencia, int numero) {//mesma coisa que falar: quer criar um conta? ent�o passa a agencia e n�mero
		Conta.total++;//static n�o � dos OBJETOS � da "Classe"
//		System.out.println("o total de contas � " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		//this.saldo = 100;
//		System.out.println("Estou criando uma conta " + this.numero);
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;

	}
	
	//aqui acontece o polimorfismo estamos recebendo uma Conta(gen�rico) e n�o especifico como ContaCorrente ou ContaPoupanca
	public boolean transfere(double valor, Conta destino) {//e aqui mais uma vez � usado o polimorfismo, reaproveitamento de c�digo
		if (this.saca(valor)) {
			destino.deposita(valor);
			return true;
		}
		return false;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("N�o pode n�mero menor ou igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("N�o pode valor menor ou igual a 0");
			return;//Ai aqui vai parar a execu��o de imediato
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {//m�todo da inst�ncia(Objeto), precisa de uma inst�ncia para executar este m�todo
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {//static = este m�todo � da classe
		//System.out.println(this.saldo);//dentro de um "contexto static" n�o existe THIS
		return Conta.total;
	}
	
}
