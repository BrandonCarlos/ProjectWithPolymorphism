public class TesteContas {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);//na transferencia tamb�m cobrou 20 centavos pois passa pelo m�todo saca()
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
		
		System.out.println(cc.saca(20));
		System.out.println(cc.getSaldo());
		
	}
}
