package thread;

public class aprendendo_thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinhaThread t1 = new MinhaThread("1", 100, 300);
		MinhaThread t2 = new MinhaThread("2", 301, 500);
		MinhaThread t3 = new MinhaThread("3", 501,700);
		t1.start();
		t2.start();
		t3.start();

	}
}

class MinhaThread extends Thread {

	private String nome;
	private int ini, fim;

	public MinhaThread(String nome, int ini, int fim) {
		this.nome = nome;
		this.ini = ini;
		this.fim = fim;
	}

	public void run() {
		for (int i = ini; i < fim; i++) {
			try {
				//Thread.sleep(2000);
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.println("Thead "+nome+" = "+i);
				}
			} catch (Exception e) {
			}
		}
		System.out.println("Thread " + nome + " concluída");
	}
}
