public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;//total é "static", agora não é de cada objeto, e sim da classe Conta, tem um pouquinho
	//de cara de váriavel GLOBAL aos objetos, agora todos os OBJETOS tem acesso a um único "total"
	
	//Se não reclararmos este constructor vázio, o próprio java implementa para nós, constructor default
	public Conta(int agencia, int numero) {//mesma coisa que falar: quer criar um conta? então passa a agencia e número
		Conta.total++;//static não é dos OBJETOS é da "Classe"
//		System.out.println("o total de contas é " + Conta.total);
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
	
	//aqui acontece o polimorfismo estamos recebendo uma Conta(genêrico) e não especifico como ContaCorrente ou ContaPoupanca
	public boolean transfere(double valor, Conta destino) {//e aqui mais uma vez é usado o polimorfismo, reaproveitamento de código
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
			System.out.println("Não pode número menor ou igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Não pode valor menor ou igual a 0");
			return;//Ai aqui vai parar a execução de imediato
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {//método da instância(Objeto), precisa de uma instância para executar este método
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {//static = este método é da classe
		//System.out.println(this.saldo);//dentro de um "contexto static" não existe THIS
		return Conta.total;
	}
	
}
