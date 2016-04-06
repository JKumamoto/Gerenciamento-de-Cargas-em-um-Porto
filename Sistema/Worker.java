import java.net.Socket;

public class Worker implements Runnable{

	private Socket Cliente;
	private DAO bd;

	public Worker(Socket Cliente, DAO bd){
		this.Cliente=Cliente;
		this.bd=bd;
  	}

	public void run() {
  	}

}
